package com.pluralsight;

public class Square extends Rectangle{

    public Square(int length, int width) {
        super(length, width);
    }

    @Override
    public int getArea() {
        if (length==width){
            return super.getArea();
        } else {
            return 0;
        }
    }
}
