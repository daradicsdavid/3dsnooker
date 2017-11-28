package shapes.table;

import main.Game;
import processing.core.PConstants;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.*;
import static constants.TableConstants.TABLE_EDGE_DEPTH;

public class RightEdge extends Shape {
    private PShape rightEdge;

    public RightEdge(Game game) {
        super(game);
    }

    public void draw() {
        rightEdge = game.createShape();
        rightEdge.beginShape(PConstants.QUADS);
        rightEdge.fill(139, 90, 43);
        rightEdge.noStroke();
        // +Z "front" face
        rightEdge.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        rightEdge.vertex(TABLE_HEIGHT, 0, 0);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, 0, 0);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);

        // +X "right" face
        rightEdge.vertex(TABLE_HEIGHT, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT, 0, 0);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        rightEdge.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -X "left" face
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        rightEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        rightEdge.fill(122);
        rightEdge.endShape();
        game.shape(rightEdge);
    }
}
