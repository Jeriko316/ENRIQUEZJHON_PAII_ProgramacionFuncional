package Grafics;

import Interfaces.Drawer;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {

    private Drawer drawer; // Almacena el Drawer actual


    public void setDrawer(Drawer drawer) {
        this.drawer = drawer;
        repaint(); // Redibuja el panel para mostrar la nueva forma
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawer != null) {
            drawer.drawShape(g); // Dibujar la forma actual
        }
    }

}
