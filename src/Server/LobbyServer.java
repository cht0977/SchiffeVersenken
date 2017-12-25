package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LobbyServer {

    private ArrayList<ClientThread> clientThreads;
    private int port;

    public static void main(String [] args){
        LobbyServer server = new LobbyServer(9003);
        System.out.println("Server is starting...");
        server.run();
    }

    public LobbyServer(int port){
        this.port = port;
        setClientThreads(new ArrayList<>());
    }

    public void run(){
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server could not be started :( ");
            System.exit(-1);
        }
        System.out.println("Server is now accepting connections on Port " + port);

        while(true){
            System.out.println("Server: Waiting for new connection");
            try {
                Socket sock = ss.accept();
                System.out.println("Server: New connection received, starting ClientThread");
                ClientThread ct = new ClientThread(sock, this);
                getClientThreads().add(ct);
                new Thread(ct).start();
                System.out.println("Server: ClientThread successfully started");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ClientThread> getClientThreads() {
        return clientThreads;
    }

    public void setClientThreads(ArrayList<ClientThread> clientThreads) {
        this.clientThreads = clientThreads;
    }

    public void invitePlayer(String fromPlayer, String toPlayer){
        System.out.println("LobbyServer: Player " + fromPlayer + " invited " + toPlayer);
    }
}
