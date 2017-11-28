package shapes;


import main.Game;
import processing.core.PConstants;
import processing.core.PShape;

import static constants.TableConstants.*;

public class Table extends Shape {

    float i = 0;

    public Table(Game game) {
        super(game);
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
        game.popMatrix();



    }

    private PShape createLowerEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);

        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH+TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createUpperEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);

        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT+TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, -TABLE_EDGE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createLeftEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);

        // +Z "front" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(0, 0, 0);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        // -Z "back" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // +Y "bottom" face
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, 0);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // -Y "top" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(0, 0, 0);
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        // +X "right" face
        shape.vertex(0, 0, 0);
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, 0);

        // -X "left" face
        shape.vertex(-TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(-TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(-TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createRightEdge() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);

        // +Z "front" face
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);

        // -Z "back" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // +Y "bottom" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // -Y "top" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT, 0, 0);
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);

        // -X "left" face
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, 0);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT + TABLE_EDGE_WIDTH, TABLE_WIDTH, 0);

        shape.fill(122);
        shape.endShape();
        return shape;
    }

    private PShape createTableTab() {
        PShape shape = game.createShape();
        shape.beginShape(PConstants.QUADS);

        // +Z "front" face
        shape.vertex(0, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(0, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));

        // -Z "back" face
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // +Y "bottom" face
        shape.vertex(0, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);

        // -Y "top" face
        shape.vertex(0, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);

        // +X "right" face
        shape.vertex(TABLE_HEIGHT, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(TABLE_HEIGHT, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(TABLE_HEIGHT, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));

        // -X "left" face
        shape.vertex(0, 0, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));
        shape.vertex(0, 0, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -TABLE_EDGE_DEPTH);
        shape.vertex(0, TABLE_WIDTH, -(TABLE_EDGE_DEPTH - TABLE_DEPTH));

        shape.fill(33);
        shape.endShape();
        return shape;
    }
}
