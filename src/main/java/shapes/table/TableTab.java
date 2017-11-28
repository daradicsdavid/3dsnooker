package shapes.table;

import main.Game;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;
import shapes.Shape;

import static constants.TableConstants.TABLE_DEPTH;
import static constants.TableConstants.TABLE_HEIGHT;
import static constants.TableConstants.TABLE_WIDTH;

public class TableTab extends Shape {
    private PShape tableTab;
    private PVector upperLeftCoordinate;
    private PVector upperRightCoordinate;
    private PVector lowerRightCoordinate;
    private PVector lowerLeftCoordinate;

    public TableTab(Game game) {
        super(game);
    }

    public void draw() {
        tableTab = game.createShape();
        tableTab.beginShape(PConstants.QUADS);
        tableTab.fill(10, 108, 3);
        tableTab.noStroke();
        captureTableTabPoints();
        // +Z "front" face
        tableTab.vertex(0, 0, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);
        tableTab.vertex(0, TABLE_WIDTH, TABLE_DEPTH);

        // -Z "back" face
        tableTab.vertex(0, 0, 0);
        tableTab.vertex(TABLE_HEIGHT, 0, 0);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        tableTab.vertex(0, TABLE_WIDTH, 0);

        // +Y "bottom" face
        tableTab.vertex(0, TABLE_WIDTH, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        tableTab.vertex(0, TABLE_WIDTH, 0);

        // -Y "top" face
        tableTab.vertex(0, 0, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, 0, 0);
        tableTab.vertex(0, 0, 0);

        // +X "right" face
        tableTab.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH);
        tableTab.vertex(TABLE_HEIGHT, 0, 0);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, 0);
        tableTab.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);

        // -X "left" face
        tableTab.vertex(0, 0, TABLE_DEPTH);
        tableTab.vertex(0, 0, 0);
        tableTab.vertex(0, TABLE_WIDTH, 0);
        tableTab.vertex(0, TABLE_WIDTH, TABLE_DEPTH);

        tableTab.fill(33);
        tableTab.endShape();
        game.shape(tableTab);
    }

    private void captureTableTabPoints() {
        upperLeftCoordinate = new PVector(0, 0, TABLE_DEPTH);
        upperRightCoordinate = new PVector(TABLE_HEIGHT, 0, TABLE_DEPTH);
        lowerRightCoordinate = new PVector(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH);
        lowerLeftCoordinate = new PVector(0, TABLE_WIDTH, TABLE_DEPTH);
    }

    public PVector getUpperLeftCoordinate() {
        return upperLeftCoordinate;
    }

    public PVector getUpperRightCoordinate() {
        return upperRightCoordinate;
    }

    public PVector getLowerRightCoordinate() {
        return lowerRightCoordinate;
    }

    public PVector getLowerLeftCoordinate() {
        return lowerLeftCoordinate;
    }
}
