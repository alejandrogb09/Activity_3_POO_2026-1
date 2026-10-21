package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrismWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel lengthLabel, widthLabel, heightLabel, volumeLabel, surfaceLabel;
    private JTextField lengthField, widthField, heightField;
    private JButton calculateButton;

    public PrismWindow() {
        start();
        setTitle("Rectangular Prism");
        setSize(280, 240);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);

        lengthLabel = new JLabel("Length (cm):");
        lengthLabel.setBounds(20, 20, 135, 23);
        lengthField = new JTextField();
        lengthField.setBounds(120, 20, 135, 23);

        widthLabel = new JLabel("Width (cm):");
        widthLabel.setBounds(20, 50, 135, 23);
        widthField = new JTextField();
        widthField.setBounds(120, 50, 135, 23);

        heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(20, 80, 135, 23);
        heightField = new JTextField();
        heightField.setBounds(120, 80, 135, 23);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(120, 110, 135, 23);
        calculateButton.addActionListener(this);

        volumeLabel = new JLabel("Volume (cm³):");
        volumeLabel.setBounds(20, 140, 220, 23);

        surfaceLabel = new JLabel("Surface Area (cm²):");
        surfaceLabel.setBounds(20, 170, 220, 23);

        contentPane.add(lengthLabel);
        contentPane.add(lengthField);
        contentPane.add(widthLabel);
        contentPane.add(widthField);
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
                double l = Double.parseDouble(lengthField.getText().trim());
                double w = Double.parseDouble(widthField.getText().trim());
                double h = Double.parseDouble(heightField.getText().trim());
                Prism prism = new Prism(l, w, h);
                volumeLabel.setText("Volume (cm³): " + String.format("%.2f", prism.getVolume()));
                surfaceLabel.setText("Surface Area (cm²): " + String.format("%.2f", prism.getSurfaceArea()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Null field or invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
