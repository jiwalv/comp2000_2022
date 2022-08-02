import javax.swing.*;

import java.awt.*;

public class Main extends JFrame {

public static void main(String[] args) throws Exception {

Main window = new Main();

}

// we dont need the canvas class anymore, so I removed it

public Main() {

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// creating a 20x20 grid

Grid grid = new Grid(20, 20);

// adding to frame

this.setContentPane(grid);

this.pack();

this.setVisible(true);

}

// a class to represent one cell on a grid

public class Cell extends JPanel {

// changable fill and border colors

Color fillColor;

Color borderColor;

// constructor taking width and height

public Cell(int width, int height) {

// using given size as the preferred size for the panel

setPreferredSize(new Dimension(width, height));

// using white as fill color, black as border

fillColor = Color.WHITE;

borderColor = Color.BLACK;

}

@Override

protected void paintComponent(Graphics g) {

super.paintComponent(g);

// using fill color

g.setColor(fillColor);

// drawing a filled rectangle covering the entire panel (of a cell,

// obviously)

g.fillRect(0, 0, getWidth(), getHeight());

// using border color, drawing an outline

g.setColor(borderColor);

g.drawRect(0, 0, getWidth(), getHeight());

}

// add getters and setters for colors if you want

}

// Grid class representing a grid of cells

public class Grid extends JPanel {

// a 2d array of Cell objects

Cell grid[][];

// constructor taking number of rows and columns

public Grid(int rows, int cols) {

// initializing 2d cell array

grid = new Cell[rows][cols];

// using a grid layout with given dimensions

setLayout(new GridLayout(rows, cols));

// looping through each row

for (int i = 0; i < rows; i++) {

// looping through each column

for (int j = 0; j < cols; j++) {

// creating a cell with width and height = 35, adding to

// current position on array

grid[i][j] = new Cell(35, 35);

// also adding element to the panel using GridLayout

add(grid[i][j]);

}

}

// later, if you want to access a cell at, say 4th row and 5th

// column, you can simply write grid[3][4] and do what is needed.

// (note: array indices start from 0, which is why I wrote 3 for 4th

// row and 4 for 5th column)

//giving an empty border around the grid

setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));