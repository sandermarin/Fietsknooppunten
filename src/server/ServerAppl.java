package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerAppl implements Runnable{

    //<editor-fold defaultstate="collapsed" desc="properties">
    //Server info
    private int iPort;
    private ServerSocket servSocket;
    private boolean statusServer;
    
    //Threadpool
    private ExecutorService pool;
    private ArrayList<ClientHandler> clients = new ArrayList();
    
    //Singleton design pattern
     private static ServerAppl serverappl = new ServerAppl(1234);
    //</editor-fold>
    
    //Private Constructor
    private ServerAppl(int port){
        this.iPort = port;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public static ServerAppl getInstance(){
        return serverappl;
    }
    
    public boolean getServerStatus(){
        return statusServer;
    }
    //</editor-fold>

    public void run() {
        startServer();

        do {
            startVerwerkingNieuweClient();
        } while (getServerStatus() == true);
    }
    
    public void startServer() {
        FrmServer.getInstance().printMessage("Start Server: Opening socket...");

        try {
            servSocket = new ServerSocket(iPort);
            FrmServer.getInstance().printMessage("Start succesfull.");
            statusServer = true;

            //threadpool creëren
            pool = Executors.newCachedThreadPool();

        } catch (IOException e) {
            FrmServer.getInstance().printMessage("Start failed.");
            System.exit(1);
        }
    }

    private void startVerwerkingNieuweClient() {
        Socket link = null;
        try {
            //wachten op client
            FrmServer.getInstance().printMessage("Server: Waiting... ");
            link = servSocket.accept();
            FrmServer.getInstance().printMessage("Server: Connection etablished.");

            //ClienHandler opstarten
            ClientHandler clh = new ClientHandler(link);
            Thread clhThread = new Thread(clh);
            //clhThread.start();
            //Werken via Thread pool
            pool.execute(clhThread);

            //alle clienthandlers worden bijgehouden in arraylist.
            clients.add(clh);

        } catch (java.io.IOException ioe) {
            //enkel échte fout als server actief is
            // als de server gesloten wordt, dan levert de regel 'link = servSock.accept();' een ioexception op
            if (getServerStatus() == true) {
                FrmServer.getInstance().printMessage("Connectie niet geslaagd.");
            }
        }
    }
    
    public void stopServer(){
        try{
            FrmServer.getInstance().printMessage("\nStop Server: waiting...");
            
            statusServer = false;
            if (pool != null){
                pool.shutdownNow();
                if(!pool.awaitTermination(5, TimeUnit.SECONDS)){
                    for(ClientHandler chl : clients){
                        chl.stopConnection();
                    }
                }
            }
            clients.clear();
            servSocket.close();
            FrmServer.getInstance().printMessage("Stop Server: succesfull.");
        } catch (IOException ex) {
            Logger.getLogger(ServerAppl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerAppl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
