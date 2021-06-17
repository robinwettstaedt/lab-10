import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface
    implements ActionListener
{
    private CalcEngine calc;
    private boolean showingAuthor;

    private JFrame frame;
    private JTextField display1;
    private JTextField display2;
    private JTextField display3;
    private JTextField display4;
    private JLabel status;

    /**
     * Create a user interface.
     * @param engine The calculator engine.
     */
    public UserInterface(CalcEngine engine)
    {
        calc = engine;
        showingAuthor = true;
        makeFrame();
        frame.setVisible(true);
    }

    /**
     * Set the visibility of the interface.
     * @param visible true if the interface is to be made visible, false otherwise.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

    /**
     * Make the frame for the user interface.
     */
    private void makeFrame()
    {
        frame = new JFrame("NO TITLE ANYMORE");
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        JPanel displayPanel = new JPanel(new GridLayout(4, 2));
        display1 = new JTextField();
        display2 = new JTextField();
        display3 = new JTextField();
        display4 = new JTextField();
        displayPanel.add(display1, BorderLayout.NORTH);
        status = new JLabel("Input Date as DD/MM/YYYY");
        displayPanel.add(status, BorderLayout.EAST);
        
        displayPanel.add(display2, BorderLayout.EAST);
        status = new JLabel("Input Date2 as DD/MM/YYYY");
        displayPanel.add(status, BorderLayout.EAST);
        
        displayPanel.add(display3, BorderLayout.EAST);
        status = new JLabel("Input Days to calculate");
        displayPanel.add(status, BorderLayout.EAST);
        
        displayPanel.add(display4, BorderLayout.SOUTH);
        status = new JLabel("Result");
        displayPanel.add(status, BorderLayout.EAST);
        
        contentPane.add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
            addButton(buttonPanel, "Add Days");
            addButton(buttonPanel, "Substract Days");
            addButton(buttonPanel, "Get difference");
            addButton(buttonPanel, "Get Weekday");

            
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel("");
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }

    /**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    private void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }

    /**
     * An interface action has been performed.
     * Find out what it was and handle it.
     * @param event The event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        if(command.equals("Add Days")) {
        	
        	calc.addDays(display1.getText(), display3.getText());    
        	String t = calc.getDisplayValue4();
        	display4.setText(t);
        }
        else if(command.equals("Substract Days")) {
        	calc.substractDays(display1.getText(), display3.getText());    
        	String t = calc.getDisplayValue4();
        	display4.setText(t);        
        	
        }
        else if(command.equals("Get difference")) {
        	calc.getDifference(display1.getText(), display2.getText());  
        	String t = calc.getDisplayValue4();	
        	display4.setText(t);
        	
        }
        else if(command.equals("Get Weekday")) {
        	System.out.println("pressed");
        	calc.getWeekday(display1.getText());
        	String t = calc.getDisplayValue4();	
        	display4.setText(t);
        
        }
        // else unknown command.

        redisplay();
    }

    /**
     * Update the interface display to show the current value of the 
     * calculator.
     */
    private void redisplay()
    {
    	//display4.setText(calc.getDisplayValue4()); 
    }

    /**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
 
}
