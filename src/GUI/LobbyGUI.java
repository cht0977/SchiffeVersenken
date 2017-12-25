package GUI;

import Client.LobbyClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class LobbyGUI implements ActionListener {

    private LobbyClient lobbyClient;
    private HashMap<JButton, String> playerButtons;
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel upperPanel;
    JPanel lowerPanel;
    JLabel upperLabel;

    public LobbyGUI(LobbyClient client){
        this.lobbyClient = client;
        playerButtons = new HashMap<>();
        mainFrame = new JFrame("Lobby");
        mainFrame.setSize(500, 800);
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        mainPanel.add(upperPanel);
        mainPanel.add(lowerPanel);
        lowerPanel.setLayout(new java.awt.GridLayout(lobbyClient.getLobbyNames().size(), 2));
        buildOptions();
        upperLabel = new JLabel("Welcome " + lobbyClient.getName());
        upperPanel.add(upperLabel);
        mainFrame.setVisible(true);
    }

    private void buildOptions(){
        for(String name : lobbyClient.getLobbyNames()){
            if(!name.equals(lobbyClient.getName())) {
                JLabel label = new JLabel(name);
                JButton button = new JButton("Invite " + name);
                button.addActionListener(this);
                lowerPanel.add(label);
                lowerPanel.add(button);
                playerButtons.put(button, name);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String player = playerButtons.get(button);
        lobbyClient.invitePlayer(player);
    }
}
