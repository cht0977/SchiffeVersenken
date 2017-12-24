package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class LobbyClient {

    private Socket s;
    private PrintWriter out;
    private BufferedReader in;
    private String name = null;
    private ArrayList<String> lobbyNames;

    public LobbyClient(Socket sock){
        this.s = sock;
        lobbyNames = new ArrayList<>();
        try {
            out=new PrintWriter(s.getOutputStream(), true);
            in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        askUserForName();
        sendNameToServer();
        createLobby();
        System.out.println("User " + name + " is connecting to the Lobby");
    }

    private void createLobby() {
        try {
            String input = in.readLine();
            if("startLobbyInformation".equals(input)){
                input = in.readLine();
                while(!"endLobbyInformation".equals(input)){
                    lobbyNames.add(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void sendNameToServer() {
        out.println(name);
    }

    private void askUserForName() {
        while(name == null) {
            JFrame jFrame = new JFrame("Name");
            String input = JOptionPane.showInputDialog(jFrame, "Bitte geben Sie Ihren Namen an");
            if (input != null && input.length() > 2) {
                name = input;
            }
        }
    }

    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost", 9003);
            LobbyClient instance = new LobbyClient(s);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
