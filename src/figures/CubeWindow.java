package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CubeWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel sideLabel, volumeLabel, surfaceLabel;
    private JTextField sideField;
    private JButton calculateButton;

    public CubeWindow() {
        start();
        setTitle("Cube");
        setSize(280, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);

        sideLabel = new JLabel("Side (cm):");
        sideLabel.setBounds(20, 20, 135, 23);
        sideField = new JTextField();
        sideField.setBounds(110, 20, 135, 23);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(110, 50, 135, 23);
        calculateButton.addActionListener(this);

        volumeLabel = new JLabel("Volume (cm³):");
        volumeLabel.setBounds(20, 90, 220, 23);

        surfaceLabel = new JLabel("Surface Area (cm²):");
        surfaceLabel.setBounds(20, 120, 220, 23);

        contentPane.add(sideLabel);
        contentPane.add(sideField);
        contentPane.add(calculateButton);
        contentPane.add(volumeLabel);
        contentPane.add(surfaceLabel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            try {
                double l = Double.parseDouble(sideField.getText().trim());
                Cube cube = new Cube(l);
                volumeLabel.setText("Volume (cm³): " + String.format("%.2f", cube.getVolume()));
                surfaceLabel.setText("Surface Area (cm²): " + String.format("%.2f", cube.getSurfaceArea()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Null field or invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
