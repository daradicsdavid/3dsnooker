package shapes.table;


import main.Game;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.*;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.CLOSE;
import static processing.core.PConstants.TRIANGLE_STRIP;

public class Table extends Shape {

    float i = 0;

    private final TableHoles tableHoles;

    public Table(Game game) {
        super(game);
        tableHoles = new TableHoles(game);
    }

    public void draw() {
        i += 0.025;
        game.pushMatrix();
        game.translate(game.width / 5, game.height / 5);
        game.rotateY(i);
        game.shape(createTableTab());
        game.shape(createLeftEdge());
        game.shape(createRightEdge());
        game.shape(createUpperEdge());
        game.shape(createLowerEdge());

        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, 0, 0);
        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, 0, TABLE_WIDTH);

        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, TABLE_HEIGHT, 0);
        drawTableLeg(TABLE_LEG_RADIUS, TABLE_LEG_HEIGHT, TABLE_HEIGHT, TABLE_WIDTH);

        tableHoles.draw();

        game.popMatrix();


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

    private PShape createLowerEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.fill(139, 90, 43);
        shape.noStroke();
        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createUpperEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.fill(139, 90, 43);
        shape.noStroke();
        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createLeftEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.fill(139, 90, 43);
        shape.noStroke();
        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, 0);
        shape.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(0, 0, 0);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // +X "right" face
        shape.vertex(0, 0, TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, 0);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createRightEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.fill(139, 90, 43);
        shape.noStroke();
        // +Z "front" face
        shape.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -X "left" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createTableTab() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);
        shape.fill(10, 108, 3);
        shape.noStroke();
        // +Z "front" face
        shape.vertex(0, 0, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, TABLE_DEPTH);

        // -Z "back" face
        shape.vertex(0, 0, 0);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, 0);

        // +Y "bottom" face
        shape.vertex(0, TABLE_WIDTH, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, 0);

        // -Y "top" face
        shape.vertex(0, 0, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(0, 0, 0);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);

        // -X "left" face
        shape.vertex(0, 0, TABLE_DEPTH);
        shape.vertex(0, 0, 0);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, TABLE_DEPTH);

        shape.fill(33);
        shape.endShape();
        return shape;
    }
}
