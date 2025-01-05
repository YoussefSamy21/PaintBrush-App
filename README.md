# Paint Brush Application

## Project Overview
The **Paint Brush Application** is a Java-based GUI project designed to simulate a basic painting application. It provides tools for drawing shapes, freehand drawing, erasing, and customizing colors and styles. This project is built using the Java Swing framework, offering an interactive and user-friendly experience.

## Features
- **Shape Drawing**: Draw rectangles, ovals, and lines.
- **Freehand Drawing**: Draw freehand with customizable colors.
- **Erase Tool**: Erase parts of the drawing with ease.
- **Color Options**: Switch between red, green, blue, and black (default).
- **Fill Styles**: Choose between filled and outlined shapes.
- **Clear All**: Reset the canvas to start fresh.

## How to Use
1. **Run the Application**: Execute the `App.java` file to launch the application.
2. **Choose a Tool**:
   - Select a shape tool (Rectangle, Oval, or Line) to start drawing shapes.
   - Use the "Free Hand" button for freehand drawing.
   - Use the "Erase" button to erase parts of your drawing.
3. **Customize**:
   - Select a color (Red, Green, or Blue) from the top control panel.
   - Use the "Filled" or "Dotted" checkboxes for additional styles.
4. **Clear Canvas**: Use the "CLEAR ALL" button to erase all drawings and start over.

## Code Structure
The project consists of the following main components:

### Files and Classes
1. **`App.java`**
   - Entry point of the application.
   - Initializes and displays the `PaintBrush` window.

2. **`PaintBrush.java`**
   - Main JFrame window that houses all components.
   - Manages layout, control panels, and drawing canvas.

3. **`MyColors.java`**
   - Handles color selection and style customization using buttons and checkboxes.

4. **`MyShapes.java`**
   - Core drawing panel that implements shape drawing, freehand drawing, and erasing.
   - Maintains a list of shapes, colors, and styles for persistent rendering.

5. **`PaintControl.java`**
   - Provides control buttons for freehand drawing, clearing the canvas, and erasing.

## Technologies and Tools Used
- **IDE**: NetBeans
- **Language**: Java
- **Framework**: Swing

## Authors
- **Youssef Samy**
- **Hala Eldaly**

## App Demo
https://github.com/YoussefSamy21/PaintBrush-App/blob/main/demo.mp4

---
Thank you for checking out the Paint Brush Application! We hope you enjoy using it as much as we enjoyed creating it.😊❤️

