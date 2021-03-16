import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.text.DecimalFormat;


public class ExpectedTimeGraphicalTest
{
    
    // Create a frame
    JFrame windowOne;
    
    // Create the panels
    JPanel panelOne;
    JPanel panelTwo;
    
    // Define labels and textfields
    private JLabel     labelProjectNumber;
    private JTextField textProjectNumber;
    
    private JLabel     labelProjectName;
    private JTextField textProjectName;
    
    private JLabel     labelOptimisticTime;
    private JTextField textOptimisticTime;
    
    private JLabel     labelRealisticTime;
    private JTextField textRealisticTime;
    
    private JLabel     labelPessimisticTime;
    private JTextField textPessimisticTime;
    
    // Define the buttons 
    private JButton calculateButton;
    private JButton exitButton;
    

    
 public ExpectedTimeGraphicalTest()
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
    textPessimisticTime  = new JTextField(4);
    panelOne.add(labelPessimisticTime);
    panelOne.add(textPessimisticTime);
    

    panelTwo = new JPanel();
    
    panelTwo.setLayout(new GridLayout(1,2));
    
    // Define the button
    calculateButton = new JButton("Calculate Expected Time");
    
    //Register the listener for the buttons
    calculateButton.addActionListener
            (new ExpectedTimeGraphicalTest.CalculateButtonListener());
        
    exitButton      = new JButton("Exit the Program");
    
    // Include and register the listener
    exitButton.addActionListener
            (new ExpectedTimeGraphicalTest.ExitButtonListener());
    
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
            int projectNumber   = Integer.parseInt(textProjectNumber.getText());
            String projectName  = textProjectName.getText();
            int optimisticTime  = Integer.parseInt(textOptimisticTime.getText());
            int realisticTime   = Integer.parseInt(textRealisticTime.getText());
            int pessimisticTime = Integer.parseInt(textPessimisticTime.getText());

            ExpectedTimeClass expectedTimeObject = new
                  ExpectedTimeClass(projectNumber,  projectName, 
                                    optimisticTime, realisticTime, 
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
                (expectedTimeObject.calculateExpectedTime()));
  
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
        ExpectedTimeGraphicalTest expectedTimeGraphicalTest = 
                                  new ExpectedTimeGraphicalTest();
 }
}
