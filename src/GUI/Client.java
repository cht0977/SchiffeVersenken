package GUI;

import implementation.Schiff;
import implementation.Schiffart;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame{

    private static String NAME = "Schiffe Versenken";
    private Spielfeld own;
    private Spielfeld enemy;
    private JComboBox<Schiffart> schiffe;

    public Client() {
        super(NAME);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        own = new Spielfeld(this);
        schiffe = new JComboBox<>();
        schiffe.addItem(Schiffart.SCHLACHTSCHIFF);
        schiffe.addItem(Schiffart.KREUZER);
        schiffe.addItem(Schiffart.UBOOT);
        schiffe.addItem(Schiffart.ZERSTOERER);
        this.add(own, BorderLayout.WEST);
        this.add(schiffe, BorderLayout.EAST);
        this.pack();
        this.setVisible(true);
    }

    public Schiffart getSelectedSchiff() {
        return (Schiffart)schiffe.getSelectedItem();
    }

    public static void main(String[] args) {
        new Client();
    }
}
