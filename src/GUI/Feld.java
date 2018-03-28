package GUI;

import implementation.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class Feld extends JButton implements ActionListener{


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setZustand(Zustand.SCHIFFGETROFFEN);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }

    enum Zustand {SCHIFF, LEER, SCHIFFGETROFFEN, LEERGETROFFEN};
    private Map<Zustand, Color> zustandFarbe;
    private Zustand zustand;
    private Position position;

    public Position getPosition() {
        return position;
    }

    public Feld(int defaultSize, Spielfeld spielfeld, int x, int y) {
        this.zustand = zustand.LEER;
        setZustandFarbe();
        this.setPreferredSize(new Dimension(defaultSize, defaultSize));
        this.setColor();
        this.addActionListener(this);
        this.position = new Position(x, y);

   }

   public void setColor() {
       this.setBackground(this.getColor());
       this.setOpaque(true);
   }

    private void setZustandFarbe() {
        zustandFarbe = new TreeMap();
        zustandFarbe.put(Zustand.LEER, Color.WHITE);
        zustandFarbe.put(Zustand.SCHIFF, Color.BLACK);
        zustandFarbe.put(Zustand.LEERGETROFFEN, Color.BLUE);
        zustandFarbe.put(Zustand.SCHIFFGETROFFEN, Color.RED);

    }

    public Zustand getZustand() {
        return zustand;
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }

    public Color getColor() {
        return zustandFarbe.get(this.zustand);
    }
}