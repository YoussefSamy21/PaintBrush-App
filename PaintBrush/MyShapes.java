/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaintBrush;

import PaintBrush.MyColors.CheckBox;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.List;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
/**
 *
 * @author Youssef Samy
 */
public class MyShapes extends JPanel implements MouseListener , MouseMotionListener
{
    private enum Shapes
    {
        NONE,
        Rectangle,
        OVAL,
        LINE
    }
    private Shapes currentshape = Shapes.NONE;
    
    private int x1 , y1 , x2 , y2;
    private List<Point> startpoints = new ArrayList<>();
    private List<Point> endpoints = new ArrayList<>();
    private List<Shapes> shapesarr = new ArrayList<>();
    private List<MyColors.Colors> colorsarr = new ArrayList<>();
    private List<MyColors.CheckBox> checkboxarr = new ArrayList<>();
    
    /***** Free Hand & Eraser Modes *****/
    private boolean isFreeHand = false;
    private boolean  isEraser = false;
    private List<Point> freeHandpoints = new ArrayList<>();
    private List<MyColors.Colors> freeHandcolorsarr = new ArrayList<>();
    private List<Point> erasewhitepoints = new ArrayList<>();
    
    private boolean freeHandReleaseFlag = false;
    private boolean erasewhiteReleaseFlag = false;
    
    
    public MyShapes() 
    {
        this.setBackground(Color.WHITE);
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        // Creating the Buttons and adding them on the Panel 
        JButton rectanglebutton = new JButton("Rectangle");
        JButton ovalbutton = new JButton("Oval");
        JButton linebutton = new JButton("Line");        
        this.add(rectanglebutton);  
        this.add(ovalbutton);
        this.add(linebutton);
        
        // Adding Mouse Listeners
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
        
        // Anonymous Inner Classes ===> Adding Action Listeners to the Buttons
        linebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentshape = Shapes.LINE;
                setFreeHandMode(false);
                setEraserMode(false);
            }
            
        });
        
        rectanglebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentshape = Shapes.Rectangle;
                setFreeHandMode(false);
                setEraserMode(false);                
            }
            
        });
        
        ovalbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentshape = Shapes.OVAL;
                setFreeHandMode(false);
                setEraserMode(false);                
            }  
        });  
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {
        if(isFreeHand)
        {
            
        }
        else if(isEraser)
        {
            
        }
        else
        {
            x1 = e.getX();
            y1 = e.getY();
            // Store here the Selected Color in order to display the current shape with the Selected Color as long as Dragging Occurs
            colorsarr.add(new MyColors().getCurrentColor()); 
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) 
    {
        if(isFreeHand)
        {
            freeHandpoints.add(new Point(e.getX(), e.getY()));
            freeHandcolorsarr.add(new MyColors().getCurrentColor());
        }
        else if(isEraser)
        {
            erasewhitepoints.add(new Point(e.getX(), e.getY()));
        }
        else
        {
            x2 = e.getX();
            y2 = e.getY();            
        }
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) 
    {
        if(isFreeHand)
        {   
            freeHandpoints.set(freeHandpoints.size()-1, new Point(-100, -100));
        }
        else if(isEraser)
        {
            
        }
        else
        {
            // record the final end point when the mouse is released
            startpoints.add(new Point(x1, y1));
            endpoints.add(new Point(e.getX() , e.getY()));

            // Add the Current Shape when Mouse is Released
            shapesarr.add(currentshape);
            // The colorsarr.add is modified in the mousePressed Event in order to display the current shape with the Selected Color as long as Dragging Occurs
            checkboxarr.add(new MyColors().getCurrentCheckBox());
        }    
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // Looping through the Previously Drawn Shapes
        for(int i = 0 ; i<startpoints.size()&& i<endpoints.size() && i<shapesarr.size() ; i++)
        {
            Point start = startpoints.get(i);
            Point end = endpoints.get(i);
            switch(colorsarr.get(i))
            {
                case RED:       g.setColor(Color.RED);
                    break;
                case GREEN:     g.setColor(Color.GREEN);
                    break;
                case BLUE:      g.setColor(Color.BLUE);
                    break;
                case DEFAULT:   g.setColor(Color.BLACK);
            }
            switch(shapesarr.get(i))
            {
                case LINE:
                        g.drawLine(start.x, start.y, end.x, end.y);
                    break;
                
                case Rectangle:
                    if(checkboxarr.get(i) == CheckBox.FILLED)
                        g.fillRect(start.x, start.y, end.x-start.x , end.y-start.y);
                    else
                        g.drawRect(start.x, start.y, end.x-start.x , end.y-start.y);
                    break;
                
                case OVAL:      
                    if(checkboxarr.get(i) == CheckBox.FILLED)
                        g.fillOval(start.x, start.y, end.x-start.x , end.y-start.y);
                    else
                        g.drawOval(start.x, start.y, end.x-start.x , end.y-start.y);
                    break;    
            }
        }
        // Drawing the Current Shape (as long as Dragging Occurs)
        if(colorsarr.size() == 0)
        {
            switch(new MyColors().getCurrentColor())
            {
                case RED:       g.setColor(Color.RED);      break;
                case GREEN:     g.setColor(Color.GREEN);    break;
                case BLUE:      g.setColor(Color.BLUE);     break;
                case DEFAULT:   g.setColor(Color.BLACK);
            }            
        }
        else
        {
            switch(colorsarr.getLast())
            {
                case RED:       g.setColor(Color.RED);      break;
                case GREEN:     g.setColor(Color.GREEN);    break;
                case BLUE:      g.setColor(Color.BLUE);     break;
                case DEFAULT:   g.setColor(Color.BLACK);
            }                 
        }       
        switch(currentshape)
        {
            case LINE:      
                
                g.drawLine(x1, y1, x2, y2);
                break;
            case Rectangle: 
                
                g.drawRect(x1, y1, x2-x1 , y2-y1);
                break;
            case OVAL:      
                
                g.drawOval(x1, y1, x2-x1 , y2-y1);
                break;      
        }
        
        /************** Free Hand & Eraser Modes *****************/
        for (int i = 1; i < freeHandpoints.size(); i++) 
        {
            
            Point p1 = freeHandpoints.get(i - 1);
            Point p2 = freeHandpoints.get(i);
            //
            if(p1.x == -100 || p2.x == -100)
                continue;
                    
            switch(freeHandcolorsarr.get(i))
            {
                case RED:       g.setColor(Color.RED);   break;
                case GREEN:     g.setColor(Color.GREEN); break;
                case BLUE:      g.setColor(Color.BLUE);  break;
                case DEFAULT:   g.setColor(Color.BLACK);
            }
            g.drawLine(p1.x ,p1.y, p2.x, p2.y);
        }
        // Erase Lines
        g.setColor(Color.WHITE);
        // Increase Thickness of the Eraser using setStroke Method
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));
        for (int i = 1; i < erasewhitepoints.size(); i++) 
        {
            Point p1 = erasewhitepoints.get(i - 1);
            Point p2 = erasewhitepoints.get(i);
            g.drawLine(p1.x ,p1.y, p2.x, p2.y);
        }
        
    }


    // This Method is Called from the PaintControl Class when "CLEAR ALL" Button is Pressed
    public void clearAll() 
    {
        startpoints.clear();
        endpoints.clear();
        shapesarr.clear();
        colorsarr.clear();
        checkboxarr.clear();
        freeHandpoints.clear();
        freeHandcolorsarr.clear();
        erasewhitepoints.clear();
        
        currentshape = Shapes.NONE; // Do NOT Draw the Current Shape 
        repaint();
    }
    // Setters of Freen Hand & Eraser Modes
    public void setFreeHandMode(boolean state)
    {
        isFreeHand = state;
        //isEraser = false; // make sure eraser is disabled
    }
    public void setEraserMode(boolean state)
    {
        isEraser = state;
        //isFreeHand = false; // make sure Free Hand is Disabled
    }
    
}
