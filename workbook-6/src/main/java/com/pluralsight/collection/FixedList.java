package com.pluralsight.collection;

import java.util.*;

public class FixedList<T> {
    List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize=maxSize;

        items = new ArrayList<T>();
    }

    public void add(T item){
        if (items.size() >= this.maxSize) {
            System.out.println("Couldn't add item\nList full");
        } else {
            items.add(item);
        }

    }

    public List<T> getItems(){
        return items;
    }
}
