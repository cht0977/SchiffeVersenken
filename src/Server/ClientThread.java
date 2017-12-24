package Server;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable{
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String name = null;
    private LobbyServer server;

    public ClientThread(Socket s, LobbyServer ls){
        this.socket = s;
        this.server = ls;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        readName();
        sendLobbyInformation();
    }

    private void sendLobbyInformation() {
        out.println("startLobbyInformation");
        for(ClientThread ct : server.getClientThreads()){
            out.println(ct.getName());
        }
        out.println("endLobbyInformation");
    }

    private void readName() {
        try {
            String n = in.readLine();
            if(n != null && n.length() > 2){
                setName(n);
                System.out.println("ClientThread: Name is " + getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
