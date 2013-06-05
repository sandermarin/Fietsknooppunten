/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import data.Fietstocht;
import data.Knooppunt;
import data.Route;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import server.dao.FietstochtDAO;
import server.dao.KnooppuntDAO;
import server.dao.RouteDAO;


/**
 *
 * @author walcariuss
 */
public class ClientHandler implements Runnable{

    private Socket link = null;
    private int clientNumber;
    private static int numberOfClientHandlers = 0;
    private boolean statusClientHandler = false;
   
    private ObjectInputStream istream;
    private ObjectOutputStream ostream;
    
    public ClientHandler(Socket link){
        this.link = link;
        this.clientNumber = numberOfClientHandlers;
        numberOfClientHandlers++;
    }
    
    public void run() {
        statusClientHandler = true;
        FrmServer.getInstance().printMessage("[ClientHandler " + clientNumber + " opstarten]");
        verwerkClient();
        FrmServer.getInstance().printMessage("[ClientHandler " + clientNumber + " ten einde]");
    }

    private void verwerkClient() {
        try{
            
            //set input & outputchannel
            istream = new ObjectInputStream(link.getInputStream());
            ostream = new ObjectOutputStream(link.getOutputStream());
            
            while(statusClientHandler == true){
                String command = (String) istream.readObject();
                
                FrmServer.getInstance().printMessage("ClientHandler boodschap ontvangen: " + command);
                
                if("downloadKnooppunten".equals(command)){
                    List<Knooppunt> knooppunten = KnooppuntDAO.laadAlleKnooppunten();
                    ostream.writeObject("sendKnooppunten");
                    ostream.writeObject(knooppunten);
                    ostream.flush();
                    System.out.println("Verzend knooppunten.");
                }
                
                if("downloadRoutesFromKnooppunt".equals(command)){
                    Knooppunt k = (Knooppunt) istream.readObject();
                    List<Route> routes = RouteDAO.haalRoutesVanuitKnooppuntOp(k.getKnooppuntId());
                    ostream.writeObject("sendRoutesFromKnooppunt");
                    ostream.writeObject(routes);
                }
                
                if("downloadFietstochten".equals(command)){
                    List<Fietstocht> fietstochten = FietstochtDAO.haalAlleFietstochtenOp();
                    ostream.writeObject("sendFietstochten");
                    ostream.writeObject(fietstochten);
                    ostream.flush();
                }
                
                if("insertFietstochtEnNodes".equals(command)){
                    Fietstocht f = (Fietstocht) istream.readObject();
                    List<Knooppunt> knooppunten = (List<Knooppunt>) istream.readObject();
                }
            }
            
        }catch(Exception ex){
            
        }
    }
    
    public void stopConnection(){
        try{
            if(!link.isClosed()){
                statusClientHandler = false;
                ostream.writeObject("CloseServer");
                ostream.flush();
            }
        }catch(IOException ex){
             FrmServer.getInstance().printMessage("[ClientHandler " + clientNumber + ":Closing failed.]");
        }
    }

}
