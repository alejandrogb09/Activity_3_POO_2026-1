package Grades;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
    private Container contentPane;
    private JLabel[] noteLabels;
    private JTextField[] noteFields;
    private JLabel avgLabel, stdDeviationLabel, highestNoteLabel, lowestNoteLabel;
    private JButton calculateButton, clearButton;
    
    public MainWindow() {
        start();
        setTitle("Grades");
        setSize(300, 480); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    private void start() {
        contentPane = getContentPane();
        contentPane.setLayout(null);
        
        noteLabels = new JLabel[5];
        noteFields = new JTextField[5];
        
        int yPosition = 20;
        for (int i = 0; i < 5; i++) {
            noteLabels[i] = new JLabel("Note " + (i + 1) + ":");
            noteLabels[i].setBounds(20, yPosition, 80, 23);
            contentPane.add(noteLabels[i]);
            
            noteFields[i] = new JTextField();
            noteFields[i].setBounds(110, yPosition, 140, 23);
            contentPane.add(noteFields[i]);
            
            yPosition += 30; 
        }
        
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(20, yPosition, 110, 25);
        calculateButton.addActionListener(this);
        contentPane.add(calculateButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(140, yPosition, 110, 25);
        clearButton.addActionListener(this);
        contentPane.add(clearButton);
        
        avgLabel = new JLabel("Average: ");
        avgLabel.setBounds(20, yPosition + 40, 250, 23);
        contentPane.add(avgLabel);
        
        stdDeviationLabel = new JLabel("Standard Deviation: ");
        stdDeviationLabel.setBounds(20, yPosition + 70, 250, 23);
        contentPane.add(stdDeviationLabel);
        
        highestNoteLabel = new JLabel("Highest Note: ");
        highestNoteLabel.setBounds(20, yPosition + 100, 250, 23);
        contentPane.add(highestNoteLabel);
        
        lowestNoteLabel = new JLabel("Lowest Note: ");
        lowestNoteLabel.setBounds(20, yPosition + 130, 250, 23);
        contentPane.add(lowestNoteLabel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            Grades grades = new Grades();
            for (int i = 0; i < 5; i++) {
                String rawInput = noteFields[i].getText().trim();
                
                if (rawInput.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Note " + (i + 1) + " has not been entered. All 5 notes are mandatory.", 
                        "Missing Data", 
                        JOptionPane.WARNING_MESSAGE);
                    noteFields[i].requestFocus(); 
                    return; 
                }
                
                try {
                    grades.gradeList[i] = Double.parseDouble(rawInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                        "The input '" + rawInput + "' in Note " + (i + 1) + " is not numeric.\nPlease enter a valid number.", 
                        "Invalid Format", 
                        JOptionPane.ERROR_MESSAGE);
                    noteFields[i].requestFocus(); 
                    return; 
                }
            }
            
            avgLabel.setText("Average: " + String.format("%.2f", grades.calculateAvg()));
            stdDeviationLabel.setText("Standard Deviation: " + String.format("%.2f", grades.calculateDeviation()));
            highestNoteLabel.setText("Highest Note: " + String.format("%.2f", grades.calculateLarger()));
            lowestNoteLabel.setText("Lowest Note: " + String.format("%.2f", grades.calculateShorter()));
        }
        
        if (event.getSource() == clearButton) {
            for (int i = 0; i < 5; i++) {
                noteFields[i].setText("");
            }
            avgLabel.setText("Average: ");
            stdDeviationLabel.setText("Standard Deviation: ");
            highestNoteLabel.setText("Highest Note: ");
            lowestNoteLabel.setText("Lowest Note: ");
        }
    }
}