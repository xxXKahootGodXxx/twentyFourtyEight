package com.example.twentyfourtyeight;

import android.widget.TextView;

public class Grid {
    private Tile[][] grid;
    private Tile empty;
    public Grid()
    {
        Tile empty = new Tile();
        grid = new Tile[4][4];
        for(Tile[] a: grid){
            for(Tile b : a){
                b = new Tile();
            }
        }
    }

    public void addRandom()
    {
        int row,col;
        while(true){
            row = (int) (Math.random()*4);
            col = (int) (Math.random()*4);

            if(grid[row][col].equals(empty) ){
                break;
            }
        }
        int val = 2;
        grid[row][col] = new Tile(val);



    }

    public boolean isLocked(){
        if(moveRight(false)||moveDown(false)||moveUp(false)||moveLeft(false)){
            return false;
        }
        return true;
    }
    public boolean moveUp(boolean move){
       boolean changed = false;
        for(int col = 0; col < 4; col++){
            for(int row = 3; row > 0; row--){
                if(grid[row][col].equals(empty)) continue;
                if(grid[row-1][col].equals(empty)){
                    if(move) grid[row-1][col].setValue(grid[row][col].setValue(0));
                    changed=true;
                }
                if(grid[row][col].equals(grid[row-1][col])){
                    if(move) grid[row-1][col].combine(grid[row][col]);
                    changed = true;
                }
            }
        }
        return changed;
    }
    public boolean moveDown(boolean move){
        boolean changed = false;
        for(int col = 0; col < 4; col++){
            for(int row = 0; row < 3; row++){
                if(grid[row][col].equals(empty)) continue;
                if(grid[row+1][col].equals(empty)){
                    if(move) grid[row+1][col].setValue(grid[row][col].setValue(0));
                    changed=true;
                }
                if(grid[row][col].equals(grid[row+1][col])){
                    if(move) grid[row+1][col].combine(grid[row][col]);
                    changed = true;
                }
            }
        }
        return changed;
    }
    public boolean moveRight(boolean move){
        boolean change = false;
        for(Tile[] row :grid){
            for(int i = 0; i < 3; i++){
                if(row[i].equals(empty)) continue;
                if(row[i+1].equals(empty)){
                    if(move) row[i+1].setValue(row[i].setValue(0));
                    change = true;
                }
                if(row[i].equals(row[i+1])){
                    if(move)
                        row[i+1].combine(row[i]);

                    change = true;
                }
            }
        }
        return change;
    }
    public boolean moveLeft(boolean move){
        boolean change = false;
        for(Tile[] row :grid){
            for(int i = 3; i > 0; i--){
                if(row[i].equals(empty)) continue;
                if(row[i-1].equals(empty)){
                    if(move) row[i-1].setValue(row[i].setValue(0));
                    change = true;
                }
                if(row[i].equals(row[i-1])){
                    if(move)
                        row[i-1].combine(row[i]);

                    change = true;
                }
            }
        }
        return change;
    }

    public String toString(){
        String str="";
        for(Tile[] a: grid){
            for(Tile b:a){
                str+=b.toString()+"\t\t";
            }
            str+="\n";
        }
        return str;
    }



}
