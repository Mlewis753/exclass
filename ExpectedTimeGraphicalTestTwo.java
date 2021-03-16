import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.text.DecimalFormat;

//  The programming refinements (method validations) to this 
//  programming model were inspired by the work of student Rachel Grissom

public class ExpectedTimeGraphicalTestTwo
{
    
    // Create a frame
    JFrame windowOne;
    
    // Create the panels
    JPanel panelOne;
    JPanel panelTwo;
    
    // Define labels and textfields
    private final JLabel     labelProjectNumber;
    private final JTextField textProjectNumber;
    
    private final JLabel     labelProjectName;
    private final JTextField textProjectName;
    
    private final JLabel     labelOptimisticTime;
    private final JTextField textOptimisticTime;
    
    private final JLabel     labelRealisticTime;
    private final JTextField textRealisticTime;
    
    private final JLabel     labelPessimisticTime;
    private final JTextField textPessimisticTime;
    
    // Define the buttons 
    private final JButton calculateButton;
    private final JButton exitButton;
    

 public ExpectedTimeGraphicalTestTwo()
 {

     panelOne = new JPanel();
    
     panelOne.setLayout(new GridLayout(5,2));
    
     labelProjectNumber = new JLabel("Enter the Project Number ");
     textProjectNumber = new JTextField();
     panelOne.add(labelProjectNumber);
     panelOne.add(textProjectNumber);
    
     labelProjectName = new JLabel("Enter the Project Name ");
     textProjectName = new JTextField();
     panelOne.add(labelProjectName);
     panelOne.add(textProjectName);
    
     labelOptimisticTime = new JLabel("Enter the Optimistic Time ");
     textOptimisticTime = new JTextField();
     panelOne.add(labelOptimisticTime);
     panelOne.add(textOptimisticTime);
    
     labelRealisticTime = new JLabel("Enter the Realistic Time ");
     textRealisticTime  = new JTextField();
     panelOne.add(labelRealisticTime);
     panelOne.add(textRealisticTime);
    
     labelPessimisticTime = new JLabel("Enter the Pessimistic Time ");
     textPessimisticTime  = new JTextField();
     panelOne.add(labelPessimisticTime);
     panelOne.add(textPessimisticTime);
   
     panelTwo = new JPanel();
    
     panelTwo.setLayout(new GridLayout(1,2));
    
     // Define the button
     calculateButton = new JButton("Calculate Expected Time");
    
     //Register the listener for the buttons
     calculateButton.addActionListener
            (new ExpectedTimeGraphicalTestTwo.CalculateButtonListener());
        
     exitButton      = new JButton("Exit the Program");
    
     // Include and register the listener
     exitButton.addActionListener
             (new ExpectedTimeGraphicalTestTwo.ExitButtonListener());
    
     // Add the buttons to the panel
     panelTwo.add(calculateButton);
     panelTwo.add(exitButton);
    
     // Create a frame
     windowOne = new JFrame();
    
     windowOne.setLayout(new FlowLayout());
    
     windowOne.setTitle("Program Evaluation Review Techniques");
     windowOne.setSize(400,400);
     windowOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
     // Add the panels to the frame
     windowOne.add(panelOne);
     windowOne.add(panelTwo);

     windowOne.setVisible(true);

 }

 // ButtonListener class to handle the buttons
 private class CalculateButtonListener implements ActionListener
 {
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == calculateButton)
        {    
            int projectNumber   = 0;
            String projectName  = null;
            int optimisticTime  = 0; 
            int realisticTime   = 0;  
            int pessimisticTime = 0;
            
            projectNumber   = validateProjectNumber();

            optimisticTime  = validateOptimisticTime();
            
            realisticTime   = validateRealisticTime();
            
            pessimisticTime = validatePessimisticTime();
            
            ExpectedTimeClass expectedTimeObject;
            expectedTimeObject = new ExpectedTimeClass(projectNumber,
                                                       projectName,
                                                       optimisticTime, 
                                                       realisticTime,
                                                       pessimisticTime);

            // Format the output
            DecimalFormat formatOutput = new DecimalFormat("#####.00");

            // Display the information for the project to the user
            JOptionPane.showMessageDialog(null,
                 "The Project Number     is " + 
                 expectedTimeObject.getProjectNumber()+ "\n"
                 + "The Project Name     is " +
                 expectedTimeObject.getProjectName() + "\n"
                 + "The Optimistic Time  is " +
                 expectedTimeObject.getOptimisticTime() + "\n"
                 + "The Realistic Time   is " + 
                 expectedTimeObject.getRealisticTime() + "\n"
                 + "The Pessimistic Time is " + 
                 expectedTimeObject.getPessimisticTime() + "\n"
                 + "The Expected Time    is " +
                 formatOutput.format
                 (expectedTimeObject.calculateExpectedTime()));        }
    }
    
    public int validateProjectNumber()
    {
        int projectNumber;
        
        try
        {
            projectNumber = Integer.parseInt(textProjectNumber.getText());
            return projectNumber;
        }
        catch (NumberFormatException event)
        {
            JOptionPane.showMessageDialog(null, "Error: " + event.getMessage() 
                   + " \nProject number must be a number.");
            textProjectNumber.setText("");
            projectNumber = Integer.parseInt(textProjectNumber.getText());
            return projectNumber;
        }
    }

    public int validateOptimisticTime()
    {
        int optimisticTime;
        
        try
        { 
            optimisticTime  = Integer.parseInt(textOptimisticTime.getText());
            return optimisticTime;
        }
        catch (NumberFormatException event)
        {
            JOptionPane.showMessageDialog(null, "Error: " + event.getMessage() 
                   + " \nOptimistic Time must be a number.");
            optimisticTime = Integer.parseInt(textOptimisticTime.getText());
            textOptimisticTime.setText("");
            return optimisticTime;
        }
    }
    
    public int validateRealisticTime()
    {
        int realisticTime;
        
        try
        { 
            realisticTime  = Integer.parseInt(textRealisticTime.getText());
            return realisticTime;
        }
        catch (NumberFormatException event)
        {
            JOptionPane.showMessageDialog(null, "Error: " + event.getMessage() 
                   + " \nRealistic Time must be a number.");
            realisticTime = Integer.parseInt(textRealisticTime.getText());
            textRealisticTime.setText("");
            return realisticTime;
        }
    }    
    
    public int validatePessimisticTime()
    {
        int pessimisticTime;
        
        try
        { 
            pessimisticTime  = Integer.parseInt(textPessimisticTime.getText());
            return pessimisticTime;
        }
        catch (NumberFormatException event)
        {
            JOptionPane.showMessageDialog(null, "Error: " + event.getMessage() 
                   + " \nPessimistic Time must be a number.");
            pessimisticTime = Integer.parseInt(textPessimisticTime.getText());
            textPessimisticTime.setText("");
            return pessimisticTime;
        }
    }
}

private class ExitButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        System.exit(0);
          
    }
}     
            
 public static void main(String[] args)
 {
        ExpectedTimeGraphicalTestTwo expectedTimeGraphicalTestTwo;
        
        expectedTimeGraphicalTestTwo = new ExpectedTimeGraphicalTestTwo();
 }
 
} // End of the class
