package main;

import processing.core.PApplet;
import shapes.table.Table;

public class Game extends PApplet {

    Table table;

    public void setup() {
        table = new Table(this);
    }

    public void settings() {
        size(800, 600, P3D);
    }

    public void draw() {
        background(137,207,240);
        table.draw();

    }

}

