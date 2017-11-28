package shapes.table;

import main.Game;
import processing.core.PConstants;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.*;
import static constants.TableConstants.TABLE_EDGE_WIDTH;
import static constants.TableConstants.TABLE_WIDTH;

public class LowerEdge extends Shape {
    private PShape lowerEdge;

    public LowerEdge(Game game) {
        super(game);
    }

    public void draw() {
        lowerEdge = game.createShape();
        lowerEdge.beginShape(PConstants.QUADS);
        lowerEdge.fill(139, 90, 43);
        lowerEdge.noStroke();
        // +Z "front" face
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);

        // +X "right" face
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        lowerEdge.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -X "left" face
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, TABLE_EDGE_DEPTH);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH + TABLE_EDGE_WIDTH, 0);
        lowerEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        lowerEdge.fill(122);
        lowerEdge.endShape();
        game.shape(lowerEdge);
    }
}
