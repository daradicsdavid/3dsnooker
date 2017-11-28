package shapes.table;

import main.Game;
import processing.core.PConstants;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.TABLE_EDGE_DEPTH;
import static constants.TableConstants.TABLE_EDGE_WIDTH;
import static constants.TableConstants.TABLE_WIDTH;

public class LeftEdge extends Shape {
    private PShape leftEdge;

    public LeftEdge(Game game) {
        super(game);
    }

    public void draw() {
        leftEdge = game.createShape();
        leftEdge.beginShape(PConstants.QUADS);
        leftEdge.fill(139, 90, 43);
        leftEdge.noStroke();
        // +Z "front" face
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, 0, 0);
        leftEdge.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -Z "back" face
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        leftEdge.vertex(0, 0, 0);
        leftEdge.vertex(0, TABLE_WIDTH, 0);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // +Y "bottom" face
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, TABLE_WIDTH, 0);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Y "top" face
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, 0, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, 0, 0);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // +X "right" face
        leftEdge.vertex(0, 0, TABLE_EDGE_DEPTH);
        leftEdge.vertex(0, 0, 0);
        leftEdge.vertex(0, TABLE_WIDTH, 0);
        leftEdge.vertex(0, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        // -X "left" face
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, TABLE_EDGE_DEPTH);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        leftEdge.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, TABLE_EDGE_DEPTH);

        leftEdge.fill(122);
        leftEdge.endShape();
        game.shape(leftEdge);
    }
}
