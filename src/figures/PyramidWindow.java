package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PyramidWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel baseLabel, heightLabel, apothemLabel, volumeLabel, surfaceLabel;
    private JTextField baseField, heightField, apothemField;
    private JButton calculateButton;

    public PyramidWindow() {
        start();
        setTitle("Pyramid");
        setSize(280, 240);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);

        baseLabel = new JLabel("Base (cm):");
        baseLabel.setBounds(20, 20, 135, 23);
        baseField = new JTextField();
        baseField.setBounds(120, 20, 135, 23);

        heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(20, 50, 135, 23);
        heightField = new JTextField();
        heightField.setBounds(120, 50, 135, 23);

        apothemLabel = new JLabel("Apothem (cm):");
        apothemLabel.setBounds(20, 80, 135, 23);
        apothemField = new JTextField();
        apothemField.setBounds(120, 80, 135, 23);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(120, 110, 135, 23);
        calculateButton.addActionListener(this);

        volumeLabel = new JLabel("Volume (cm³):");
        volumeLabel.setBounds(20, 140, 220, 23);

        surfaceLabel = new JLabel("Surface Area (cm²):");
        surfaceLabel.setBounds(20, 170, 220, 23);

        contentPane.add(baseLabel);
        contentPane.add(baseField);
        contentPane.add(heightLabel);
        contentPane.add(heightField);
        contentPane.add(apothemLabel);
        contentPane.add(apothemField);
        contentPane.add(calculateButton);
        contentPane.add(volumeLabel);
        contentPane.add(surfaceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            try {
                double b = Double.parseDouble(baseField.getText().trim());
                double h = Double.parseDouble(heightField.getText().trim());
                double a = Double.parseDouble(apothemField.getText().trim());
                Pyramid pyramid = new Pyramid(b, h, a);
                volumeLabel.setText("Volume (cm³): " + String.format("%.2f", pyramid.getVolume()));
                surfaceLabel.setText("Surface Area (cm²): " + String.format("%.2f", pyramid.getSurfaceArea()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Null field or invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
