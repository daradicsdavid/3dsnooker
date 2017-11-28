package shapes.table;

import main.Game;
import processing.core.PConstants;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.TABLE_EDGE_DEPTH;
import static constants.TableConstants.TABLE_EDGE_WIDTH;
import static constants.TableConstants.TABLE_HEIGHT;

public class UpperEdge extends Shape {
    private PShape upperEdge;

    public UpperEdge(Game game) {
        super(game);
    }

    public void draw() {
        upperEdge = game.createShape();
        upperEdge.beginShape(PConstants.QUADS);
        upperEdge.fill(139, 90, 43);
        upperEdge.noStroke();
        // +Z "front" face
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);

        // -Z "back" face
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // +Y "bottom" face
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // -Y "top" face
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);

        // +X "right" face
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        upperEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);

        // -X "left" face
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        upperEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        upperEdge.fill(122);
        upperEdge.endShape();
        game.shape(upperEdge);
    }
}
