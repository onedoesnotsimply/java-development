package com.pluralsight;

public class Rectangle extends Shape{
    protected int length;
    protected int width;

    public Rectangle(int length, int width){
        this.length=length;
        this.width=width;
    }

    //@Override
    public int getArea() {
        return length*width;
    }
}
