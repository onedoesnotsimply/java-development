package com.pluralsight;

public class Box extends Rectangle {
    private int height;

    public Box(int length, int width, int height) {
        super(length,width);
        this.height=height;
    }

    @Override
    public int getArea() {
        return 2*((height*width)+(width*length)+(height*length));
    }
}
