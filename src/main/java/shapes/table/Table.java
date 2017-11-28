package shapes.table;


import main.Game;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
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
    private final TableTab tableTab;
    private final LeftEdge leftEdge;
    private final RightEdge rightEdge;
    private final UpperEdge upperEdge;
    private final LowerEdge lowerEdge;
    private final TableLegs tableLegs;

    public Table(Game game) {
        super(game);
        tableHoles = new TableHoles(game);
        tableTab = new TableTab(game);
        leftEdge = new LeftEdge(game);
        rightEdge = new RightEdge(game);
        upperEdge = new UpperEdge(game);
        lowerEdge = new LowerEdge(game);
        tableLegs = new TableLegs(game);
    }

    public void draw() {
        i += 0.025;
        game.pushMatrix();
        game.translate(game.width / 5, game.height / 5);
        game.rotateY(i);
        tableTab.draw();
        leftEdge.draw();
        rightEdge.draw();
        upperEdge.draw();
        lowerEdge.draw();
        tableHoles.draw();
        tableLegs.draw();

        game.translate((tableTab.getUpperLeftCoordinate().x + tableTab.getLowerRightCoordinate().x) / 2, (tableTab.getUpperLeftCoordinate().y + tableTab.getLowerRightCoordinate().y) / 2, tableTab.getUpperLeftCoordinate().z + BALL_RADIUS);
        game.noStroke();
        game.fill(255);
        game.sphere(BALL_RADIUS);

        game.popMatrix();


    }


}
