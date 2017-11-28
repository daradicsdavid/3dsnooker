package main;

import processing.core.PApplet;
import shapes.Table;

public class Game extends PApplet {

    Table table;

    public void settings() {
        size(1500, 1500, P3D);

        table = new Table(this);
    }

    public void draw() {
        background(0);
        table.draw();

    }

}

