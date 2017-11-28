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

    void drawCylinder(int sides, float r, float h) {
        float angle = 360 / sides;
        float halfHeight = h / 2;
        // draw top shape
        beginShape();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, -halfHeight);
        }
        endShape(CLOSE);
        // draw bottom shape
        beginShape();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, halfHeight);
        }
        endShape(CLOSE);

        beginShape(TRIANGLE_STRIP);
        for (int i = 0; i < sides + 1; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, halfHeight);
            vertex(x, y, -halfHeight);
        }
        endShape(CLOSE);
    }
}

