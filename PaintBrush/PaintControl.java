/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrush;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Youssef Samy
 */
public class PaintControl extends JPanel
{
    private PaintBrush paintBrush;
    
    private boolean eraserFlag = false;
    private boolean freehandFlag = false;
    
    public PaintControl(PaintBrush paintBrush) 
    {
        this.paintBrush = paintBrush; // Save reference to Clear Drawings of MyShapes
        this.setBackground(Color.WHITE);
        JButton freehandbutton = new JButton("Free Hand");
        JButton clearallbutton = new JButton("CLEAR ALL");
        JButton eraserbutton = new JButton("Erase");
        this.add(freehandbutton);
        this.add(clearallbutton);
        this.add(eraserbutton);
        this.setFocusable(true);
        // Anonymous Inner Classes ===> Adding Action Listeners to the Buttons
        freehandbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                paintBrush.myshapes.setFreeHandMode(true);
                paintBrush.myshapes.setEraserMode(false);
            }
            
        });
        
        clearallbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                paintBrush.myshapes.setEraserMode(false);
                paintBrush.myshapes.setFreeHandMode(false);
                
                paintBrush.myshapes.clearAll(); // Call clearAll on the PaintBrush instance
            }
            
        });
        
        eraserbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                paintBrush.myshapes.setEraserMode(true);
                paintBrush.myshapes.setFreeHandMode(false);
            }
            
        }); 
    }    
}
