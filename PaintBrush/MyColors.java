/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrush;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Youssef Samy
 */
public class MyColors extends JPanel
{
    public enum Colors
    {   
        DEFAULT,
        RED,
        GREEN,
        BLUE
    }
    public enum CheckBox
    {
        DEFAULT,
        DOTTED,
        FILLED
    }
    public static Colors   currentcolor = Colors.DEFAULT;
    public static CheckBox currentcheckbox  = CheckBox.DEFAULT;
    
    public MyColors() 
    {
        this.setBackground(Color.WHITE);
        
        JButton redbutton = new JButton("Red");
        JButton greenbutton = new JButton("Green");
        JButton bluebutton = new JButton("Blue");
        JCheckBox dottedcheck = new JCheckBox("Dotted");
        JCheckBox filledcheck = new JCheckBox("Filled");
        this.add(redbutton);
        this.add(greenbutton);
        this.add(bluebutton);
        this.add(dottedcheck);
        this.add(filledcheck);
        this.setFocusable(true);

        // Anonymous Inner Classes ===> Adding Action Listeners to the Buttons
        redbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentcolor = Colors.RED;
            }
            
        });
        
        greenbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentcolor = Colors.GREEN;
            }
            
        });
        
        bluebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentcolor = Colors.BLUE;
            }
            
        });
        
        
        dottedcheck.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED) // SELECTED = 1 , DESELECTED = 2
                    currentcheckbox = CheckBox.DOTTED;
                else
                    currentcheckbox = CheckBox.DEFAULT;
                
            }
            
        });
        
        filledcheck.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED) // SELECTED = 1 , DESELECTED = 2
                    currentcheckbox = CheckBox.FILLED;
                else
                    currentcheckbox = CheckBox.DEFAULT;
            }
            
        });
    }
    
    // Getters to get Current Color & CheckBox
    public Colors getCurrentColor()
    {
        return currentcolor;
    }
    public CheckBox getCurrentCheckBox()
    {
        return currentcheckbox;
    }
    
}
