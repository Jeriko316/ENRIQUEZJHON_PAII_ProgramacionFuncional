package Grafics;

import Interfaces.Drawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Window extends JFrame {


    private Paint drawingPanel; // Panel donde se mostrarán las figuras


    public Window() {
        setTitle("Ventana Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear botones con funcionalidad de dibujado
        JButton squareButton = createButton("Cuadrado", g -> {
            g.drawRect(50, 50, 200, 200); // Dibujar un cuadrado en el panel
        });

        JButton triangleButton = createButton("Triángulo", g -> {
           int[] xPoints = {150, 100, 200};
           int[] yPoints = {50, 200, 200};
            g.drawPolygon(xPoints, yPoints, 3); // Dibujar un triángulo en el panel
        });

        JButton circleButton = createButton("Círculo", g -> {
            g.drawOval(50, 50, 200, 200); // Dibujar un círculo en el panel
        });

        // Crear el panel de dibujo
        drawingPanel = new Paint();
        drawingPanel.setPreferredSize(new Dimension(400, 300));
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Añadir un borde al panel

        // Crear un panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(squareButton);
        buttonPanel.add(triangleButton);
        buttonPanel.add(circleButton);

        // Añadir los paneles a la ventana principal
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

    }

    private JButton createButton(String label, Drawer shapeDrawer) {
        JButton button = new JButton(label);
        button.addActionListener((ActionEvent e) -> {
            drawingPanel.setDrawer(shapeDrawer); // Configurar el Drawer actual
        });
        return button;
    }
}
