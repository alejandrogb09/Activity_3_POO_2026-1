package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CylinderWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel radiusLabel, heightLabel, volumeLabel, surfaceLabel;
    private JTextField radiusField, heightField;
    private JButton calculateButton;

    public CylinderWindow() {
        start();
        setTitle("Cylinder");
        setSize(280, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);

        radiusLabel = new JLabel("Radius (cm):");
        radiusLabel.setBounds(20, 20, 135, 23);
        radiusField = new JTextField();
        radiusField.setBounds(110, 20, 135, 23);

        heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(20, 50, 135, 23);
        heightField = new JTextField();
        heightField.setBounds(110, 50, 135, 23);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(110, 80, 135, 23);
        calculateButton.addActionListener(this);

        volumeLabel = new JLabel("Volume (cm³):");
        volumeLabel.setBounds(20, 110, 220, 23);

        surfaceLabel = new JLabel("Surface Area (cm²):");
        surfaceLabel.setBounds(20, 140, 220, 23);

        contentPane.add(radiusLabel);
        contentPane.add(radiusField);
        contentPane.add(heightLabel);
        contentPane.add(heightField);
        contentPane.add(calculateButton);
        contentPane.add(volumeLabel);
        contentPane.add(surfaceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            try {
                double r = Double.parseDouble(radiusField.getText().trim());
                double h = Double.parseDouble(heightField.getText().trim());
                Cylinder cylinder = new Cylinder(r, h);
                volumeLabel.setText("Volume (cm³): " + String.format("%.2f", cylinder.getVolume()));
                surfaceLabel.setText("Surface Area (cm²): " + String.format("%.2f", cylinder.getSurfaceArea()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Null field or invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
