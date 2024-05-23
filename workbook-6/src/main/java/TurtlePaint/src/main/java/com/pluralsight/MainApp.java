package TurtlePaint.src.main.java.com.pluralsight;

import TurtlePaint.src.main.java.com.pluralsight.forms.*;

import java.awt.*;

public class MainApp
{
    // Make world static so that you can use it in the methods
    // The world is your canvas
    static World world = new World(200, 200);

    public static void main(String[] args)
    {
        /*
        int width = 200;
        int height = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(width, 2);
        double heightSquared = Math.pow(height, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);

        turtle.turnRight(45);
        turtle.forward(hypotenuse);

        turtle.penUp();
        turtle.goTo(100, 100);
        turtle.turnRight(90);

        turtle.penDown();
        turtle.forward(hypotenuse);
         */

        drawSquare();
        drawCircle();
        drawShape();

    }

    static void drawShape() {
        // Draw the other shape
        Turtle turtle = new Turtle(world,0,0);
        turtle.setColor(Color.RED);
        turtle.setPenWidth(3);
        turtle.forward(50);
        turtle.turnLeft(90);
        for (int i = 270; i > 0; i--){
            turtle.forward(1);
            turtle.turnLeft(1);
        }
        turtle.turnLeft(90);
        turtle.forward(50);

        turtle.penUp();
        turtle.turnRight(90);
        turtle.forward(10);
        turtle.setColor(Color.BLUE);
        turtle.penDown();
        turtle.forward(50);
        turtle.turnRight(90);
        for (int i=90;i>0;i--){
            turtle.forward(1);
            turtle.turnRight(1);
        }
        turtle.turnRight(90);
        turtle.forward(50);
    }

    static void drawCircle() {
        //Draw a circle
        Turtle turtle = new Turtle(world, 0,50);
        turtle.setColor(Color.MAGENTA);
        turtle.setPenWidth(3);
        for (int i = 360; i > 0; i--){
            turtle.forward(1);
            turtle.turnLeft(1);
        }
    }

    static void drawSquare() {
        Turtle turtle = new Turtle(world, -50, 50);

        turtle.setPenWidth(3);
        turtle.setColor(Color.BLUE);

        //Draw the square
        turtle.forward(100);
        turtle.turnLeft(90);
        turtle.forward(100);
        turtle.turnLeft(90);
        turtle.forward(100);
        turtle.turnLeft(90);
        turtle.forward(100);
    }
}
