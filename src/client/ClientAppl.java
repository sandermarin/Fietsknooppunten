package client;

import data.Fietstocht;
import data.Knooppunt;
import data.Route;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientAppl {
    private InetAddress host;
    private int port;
    private Socket link = null;
    private ObjectInputStream istream;
    private ObjectOutputStream ostream;
    private FrmClient frmClient;
    
    public ClientAppl(InetAddress host, int port, FrmClient frm){
        this.host = host;
        this.port = port;
        this.frmClient = frm;
    }
    
    public ClientAppl(String sIP, int port, FrmClient frm) throws UnknownHostException {
        this(InetAddress.getByName(sIP), port, frm);
    }
    
    public void makeConnection() throws IOException, java.net.ConnectException {
        if (link == null) {
            System.out.println("Make connection...");
            //1: connectie maken
            link = new Socket(host, port);

            //2: input & outputkanaal instellen
            System.out.println("Inputkanaal & outputkanaal vastleggen...");
            ostream = new ObjectOutputStream(link.getOutputStream());
            System.out.println("Ok - output");
            istream = new ObjectInputStream(link.getInputStream());
            System.out.println("Ok - input");

            //3 NIEUW: AcceptMessageHandler opstarten
            AcceptMessageHandler amh = new AcceptMessageHandler();
            Thread t = new Thread(amh);
            t.start();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Send">
    
    public void getKnooppunten() throws IOException{
        ostream.writeObject("downloadKnooppunten");
        ostream.flush();
    }
    
    public void getRoutesFromKnooppunt(Knooppunt k) throws IOException{
        ostream.writeObject("downloadRoutesFromKnooppunt");
        ostream.writeObject(k);
        ostream.flush();
    }
    
    public void insertFietstocht(Fietstocht f, List<Knooppunt> knooppunten) throws IOException{
        ostream.writeObject("insertFietstochtEnNodes");
        ostream.writeObject(f);
        ostream.writeObject(knooppunten);
        ostream.flush();
    }
    
    //</editor-fold>
    
    class AcceptMessageHandler implements Runnable {
        //DOEL: continue luisteren en afhankelijk van binnenkomend bericht 'iets' ondernemen

        private boolean statusAcceptMessageHandler = false;

        public void run() {
            System.out.println("AcceptMessageHandler is opgestart");

            try {
                statusAcceptMessageHandler = true;

                while (statusAcceptMessageHandler == true) {
                    String command = (String) istream.readObject();
                    System.out.println("analyse binnengekomen boodschap:" + command);

                    if (command.equals("sendKnooppunten")) {
                        List<Knooppunt> knooppunten = (ArrayList<Knooppunt>) istream.readObject();
                        frmClient.toonKnooppunten(knooppunten);
                        System.out.println("Aantal knooppunten in binnenkomende ArrayList: " + knooppunten.size());
                    }
                    
                    if(command.equals("sendRoutesFromKnooppunt")){
                        List<Route> routes = (List<Route>) istream.readObject();
                        frmClient.vulRoutes(routes);
                        System.out.println("Aantal routes in binnenkomende ArrayList: " + routes.size());
                    }

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientAppl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (    IOException ex) {
                //frmClient.toonAntwoord(ex.getMessage());
                ex.printStackTrace();
            }

        }
    }
}
