package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton cylinderButton, sphereButton, pyramidButton, cubeButton, prismButton;

    public MainWindow() {
        start();
        setTitle("3D Geometric Figures");
        setSize(480, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);

        cylinderButton = new JButton("Cylinder");
        cylinderButton.setBounds(20, 40, 90, 30);
        cylinderButton.addActionListener(this);

        sphereButton = new JButton("Sphere");
        sphereButton.setBounds(120, 40, 85, 30);
        sphereButton.addActionListener(this);

        pyramidButton = new JButton("Pyramid");
        pyramidButton.setBounds(215, 40, 95, 30);
        pyramidButton.addActionListener(this);

        cubeButton = new JButton("Cube");
        cubeButton.setBounds(320, 40, 75, 30);
        cubeButton.addActionListener(this);

        prismButton = new JButton("Prism");
        prismButton.setBounds(180, 80, 85, 30);
        prismButton.addActionListener(this);

        contentPane.add(cylinderButton);
        contentPane.add(sphereButton);
        contentPane.add(pyramidButton);
        contentPane.add(cubeButton);
        contentPane.add(prismButton);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == cylinderButton) {
            CylinderWindow cylinderWindow = new CylinderWindow();
            cylinderWindow.setVisible(true);
        }
        if (event.getSource() == sphereButton) {
            SphereWindow sphereWindow = new SphereWindow();
            sphereWindow.setVisible(true);
        }
        if (event.getSource() == pyramidButton) {
            PyramidWindow pyramidWindow = new PyramidWindow();
            pyramidWindow.setVisible(true);
        }
        if (event.getSource() == cubeButton) {
            CubeWindow cubeWindow = new CubeWindow();
            cubeWindow.setVisible(true);
        }
        if (event.getSource() == prismButton) {
            PrismWindow prismWindow = new PrismWindow();
            prismWindow.setVisible(true);
        }
    }
}
