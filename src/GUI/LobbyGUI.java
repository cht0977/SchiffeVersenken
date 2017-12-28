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
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel upperLabel;
    private JButton refreshButton;

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
        upperPanel.setLayout(new javax.swing.BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        upperPanel.add(upperLabel);
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        upperPanel.add(refreshButton);
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

    private void refreshOptions(){
        lowerPanel.removeAll();
        playerButtons.clear();
        buildOptions();
        mainFrame.repaint();
        mainFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == refreshButton){
            refreshOptions();
        }
        else {
            JButton button = (JButton) e.getSource();
            String player = playerButtons.get(button);
            lobbyClient.invitePlayer(player);
        }
    }
}
