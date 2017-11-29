package main;

import processing.core.PApplet;
import shapes.table.Table;

public class Game extends PApplet {

    Table table;

    public void setup() {

        frameRate(30);
        table = new Table(this);
    }

    public void settings() {
        size(800, 600, P3D);
    }

    public void draw() {
        background(0);
        table.draw();

    }

}

