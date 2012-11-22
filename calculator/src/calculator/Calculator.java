/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author workstation 
 */
/*
 * Author: Havard Rast Blok extended by workstation
 * workstation - added C button and user can see what he is solving
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * A simple calculator.
 */
public class Calculator extends JFrame implements ActionListener
{
  // arithmetic variables
  private char savedAction;
  private boolean clear;
  private boolean reset;
  private float savedValue;
   
  // GUI variables
  private JTextField display;
  private JTextField operatorShow;
  private JPanel buttonsPanel;
  private JButton buttons[];
  
  public Calculator()
  {
    setupGUI();
    
    //set to 'true' to delete display at start
    clear = true;
  }
  
  private void setupGUI()
  {
    // add panels and layouts
    Container c = getContentPane();
    c.setLayout( new BorderLayout() );
    
    
    operatorShow = new JTextField("");
    operatorShow.setEditable(false);
    display = new JTextField("0");
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.TRAILING);
    c.add(display, BorderLayout.NORTH);
    
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout( new GridLayout(5,5) );
    c.add( buttonsPanel, BorderLayout.CENTER );
    buttons = new JButton[17];
    
    // make the buttons, set ActionListener and add to panel
    for(int i=0; i<buttons.length; i++)
    {
      buttons[i] = new JButton();
      buttons[i].addActionListener( this );
      buttonsPanel.add( buttons[i] );
    }
    
    buttonsPanel.add(new JLabel("")); //really dumb way to space
    buttonsPanel.add(operatorShow);
    
    
    buttonsPanel.add(new JLabel("Calculator"));
    
    // set the number captions
    buttons[0].setText("7");
    buttons[1].setText("8");
    buttons[2].setText("9");
    buttons[4].setText("4");
    buttons[5].setText("5");
    buttons[6].setText("6");
    buttons[8].setText("1");
    buttons[9].setText("2");
    buttons[10].setText("3");
    buttons[12].setText("0");
    
    // set other captions
    buttons[3].setText("/");
    buttons[7].setText("*");
    buttons[11].setText("-");
    buttons[15].setText("+");
    buttons[13].setText(".");
    buttons[14].setText("C");
    
    buttons[16].setText("=");
    
    pack();
  }
  
  public void actionPerformed( ActionEvent e )
  {
    String str;
    char cmd;
    
    // get caption from button and convert to char
    str = e.getActionCommand();
    
    
    cmd = (str.toCharArray())[0];
   
    if(reset) {
        operatorShow.setText("");
        reset = false;
    }
    if (operatorShow.getText() == "" && cmd != '.')
    {
        operatorShow.setText("");
        operatorShow.setText(""+cmd );
    } else {
        operatorShow.setText(operatorShow.getText() + cmd );
    }
   
    // display or calulate
    if( Character.isDigit( cmd ) || cmd == '.' )
    {
      if( clear )
      {
        // save current value and clear the display
        savedValue = Float.parseFloat( display.getText() );
        display.setText("");
        clear = false;
      }
      
      // add new digit to display
      display.setText( display.getText() + cmd );
       
    }
    else if(cmd == 'C') {
        savedAction = 0;
        display.setText("");
        clear = false;
        operatorShow.setText("");
        reset = false;
        
    }  else
    {
      calculate(cmd);
    }
  }
  
  private void calculate(char cmd)
  {
    float curValue;
    float newValue = 0;
    
    // get current value of display
    curValue = Float.parseFloat( display.getText() );
    
    if( savedAction == 0 )
    {
      // if no previous action was save, save this one and clear
      clear = true;
      savedAction = cmd;
    }
    else
    {
      // perform the previous action
      switch(savedAction)
      {
        case '/':
                  newValue = savedValue / curValue;
                  break;
        case '*':
                  newValue = savedValue * curValue;
                  break;
        case '-':
                  newValue = savedValue - curValue;
                  break;
        case '+':
                  newValue = savedValue + curValue;
                  break;                  
      }
      
      // display the result and order to clear
      display.setText(""+newValue);
      operatorShow.setText(operatorShow.getText() + newValue );
      reset = true;
      clear = true;
      
      if( cmd == '=' )
      {
        //do not save = action
        savedAction = 0;
      }
      else
      {
        // save other actions
        savedAction = cmd;
      }
    }

  }

  public static void main(String args[])
  {
    new Calculator().show();
  }
  

  
}
