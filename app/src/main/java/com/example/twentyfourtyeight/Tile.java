package com.example.twentyfourtyeight;

public class Tile {
    private int value;
    public Tile(int val){
        value = val;
    }
    public Tile(){
        value = 0;
    }

    public int getValue(){
        return value;
    }
    public int setValue(int val){
        int temp = value;
        value = val;
        return value;
    }

    public boolean equals(Tile t){
        return this.getValue() == t.getValue();
    }
    public void combine(Tile t){
        value = getValue()*2;
        t.setValue(0);
    }

    @Override
    public String toString() {
        Integer i = new Integer(value);
        return i.toString();
    }
}
