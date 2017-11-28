package main;

import processing.core.PApplet;
import shapes.table.Table;

public class Game extends PApplet {

    Table table;

    public void settings() {
        size(800, 600, P3D);

        table = new Table(this);
    }

    public void draw() {
        background(0);
        table.draw();

    }

}

