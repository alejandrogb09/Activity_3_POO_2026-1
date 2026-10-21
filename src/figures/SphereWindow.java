package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SphereWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel radiusLabel, volumeLabel, surfaceLabel;
    private JTextField radiusField;
    private JButton calculateButton;

    public SphereWindow() {
        start();
        setTitle("Sphere");
        setSize(280, 200);
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

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(110, 50, 135, 23);
        calculateButton.addActionListener(this);

        volumeLabel = new JLabel("Volume (cm³):");
        volumeLabel.setBounds(20, 90, 220, 23);

        surfaceLabel = new JLabel("Surface Area (cm²):");
        surfaceLabel.setBounds(20, 120, 220, 23);

        contentPane.add(radiusLabel);
        contentPane.add(radiusField);
        contentPane.add(calculateButton);
        contentPane.add(volumeLabel);
        contentPane.add(surfaceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            try {
                double r = Double.parseDouble(radiusField.getText().trim());
                Sphere sphere = new Sphere(r);
                volumeLabel.setText("Volume (cm³): " + String.format("%.2f", sphere.getVolume()));
                surfaceLabel.setText("Surface Area (cm²): " + String.format("%.2f", sphere.getSurfaceArea()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Null field or invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
