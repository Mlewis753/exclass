import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.text.DecimalFormat;


public class ExpectedTimeGraphicalTestOne
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
    

    
 public ExpectedTimeGraphicalTestOne()
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
            (new ExpectedTimeGraphicalTestOne.CalculateButtonListener());
        
     exitButton      = new JButton("Exit the Program");
    
     // Include and register the listener
     exitButton.addActionListener
             (new ExpectedTimeGraphicalTestOne.ExitButtonListener());
    
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
            String projectName ;
            int optimisticTime  = 0; 
            int realisticTime   = 0;  
            int pessimisticTime = 0;
            
            try
            { 
              projectNumber   = Integer.parseInt(textProjectNumber.getText());
            }
            catch (NumberFormatException e)
            {
              System.out.println("A number must be entered for the "
                                 + "project number");
            }
            
            projectName  = textProjectName.getText();
            
            try
            { 
              optimisticTime  = Integer.parseInt(textOptimisticTime.getText());
            }
            catch (NumberFormatException e)
            {
              System.out.println("A number must be entered for the "
                                 + "optimistic time");
            }
            
            try
            { 
              realisticTime   = Integer.parseInt(textRealisticTime.getText());
            }
            catch (NumberFormatException e)
            {
              System.out.println("A number must be entered for the "
                                 + "realistic time");
            }
            try
            { 
              pessimisticTime = Integer.parseInt(textPessimisticTime.getText());
            }
            catch (NumberFormatException e)
            {
              System.out.println("A number must be entered for the "
                                 + "pessimistic time");
            }

            
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
        ExpectedTimeGraphicalTestOne expectedTimeGraphicalTestOne;
        
        expectedTimeGraphicalTestOne = new ExpectedTimeGraphicalTestOne();
 }
 
} // End of the class
