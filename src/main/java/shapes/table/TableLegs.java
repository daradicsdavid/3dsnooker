package shapes.table;

import main.Game;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.*;
import static constants.TableConstants.TABLE_WIDTH;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.CLOSE;
import static processing.core.PConstants.TRIANGLE_STRIP;

public class TableLegs extends Shape {

    public TableLegs(Game game) {
        super(game);
    }

    public void draw() {
        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, 0, 0);
        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, 0, TABLE_WIDTH);

        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, TABLE_HEIGHT, 0);
        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, TABLE_HEIGHT, TABLE_WIDTH);
    }

    void drawTableLeg(float r, float h, float xOffset, float yOffset) {
        float sides = 360;
        float angle = 360 / sides;
        PShape upperShape = game.createShape();
        upperShape.beginShape();
        upperShape.fill(139, 90, 43);
        upperShape.noStroke();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            upperShape.vertex(x + xOffset, y + yOffset, 0);
        }
        upperShape.endShape(CLOSE);
        game.shape(upperShape);

        PShape lowerShape = game.createShape();
        lowerShape.beginShape();
        lowerShape.fill(139, 90, 43);
        lowerShape.noStroke();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            lowerShape.vertex(x + xOffset, y + yOffset, -h);
        }
        lowerShape.endShape(CLOSE);
        game.shape(lowerShape);

        PShape body = game.createShape();
        body.beginShape(TRIANGLE_STRIP);
        body.fill(139, 90, 43);
        body.noStroke();
        for (int i = 0; i < sides + 1; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            body.vertex(x + xOffset, y + yOffset, 0);
            body.vertex(x + xOffset, y + yOffset, -h);
        }
        body.endShape(CLOSE);
        game.shape(body);
    }

}
