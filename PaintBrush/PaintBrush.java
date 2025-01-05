/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrush;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Youssef Samy
 */

public class PaintBrush extends JPanel
{
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    
    private JFrame myframe = new JFrame();
    MyColors mycolors = new MyColors();
    MyShapes myshapes= new MyShapes();
    
    public PaintBrush()
    {
        myframe.setTitle("Paint Brush App");
        myframe.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setBackground(Color.WHITE);
        
        myframe.setLayout(new BorderLayout()); 

        PaintControl paintcontrol = new PaintControl(this);
        
        // Add control panels at the top of the Frame
        JPanel controls = new JPanel(new GridLayout(1, 2));
        controls.add(mycolors);
        controls.add(paintcontrol);
        myframe.add(controls, BorderLayout.NORTH);

        // Add drawing panel to the center
        myframe.add(myshapes, BorderLayout.CENTER);

        myframe.setVisible(true);
        
    }
    public PaintBrush(int width , int height , String title)
    {
        myframe.setTitle(title);
        myframe.setSize(width, height);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setBackground(Color.WHITE);
        
        myframe.setLayout(new BorderLayout()); 

        PaintControl paintcontrol = new PaintControl(this);
        
        // Add control panels at the top of the Frame
        JPanel controls = new JPanel(new GridLayout(1, 2));
        controls.setBackground(Color.WHITE);
        controls.add(mycolors);
        controls.add(paintcontrol);
        myframe.add(controls, BorderLayout.NORTH);

        // Add drawing panel to the center
        myframe.add(myshapes, BorderLayout.CENTER);

        myframe.setVisible(true);
    }
    
}
