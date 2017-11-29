package shapes.table;


import main.Game;
import processing.core.PVector;
import shapes.Ball;
import shapes.Shape;

import static constants.TableConstants.*;


public class Table extends Shape {

    float i = 0;

    boolean gameStarted = false;

    private final TableHoles tableHoles;
    private final TableTab tableTab;
    private final LeftEdge leftEdge;
    private final RightEdge rightEdge;
    private final UpperEdge upperEdge;
    private final LowerEdge lowerEdge;
    private final TableLegs tableLegs;
    private final Ball whiteBall;


    public Table(Game game) {
        super(game);
        tableHoles = new TableHoles(game);
        tableTab = new TableTab(game);
        leftEdge = new LeftEdge(game);
        rightEdge = new RightEdge(game);
        upperEdge = new UpperEdge(game);
        lowerEdge = new LowerEdge(game);
        tableLegs = new TableLegs(game);

        whiteBall = new Ball(game, tableTab, 255, 255, 255);
    }

    public void draw() {
        i += 0.025;
        game.pushMatrix();
        game.translate(game.width / 5, game.height / 5);
        //game.rotateY(i);
        tableTab.draw();
        leftEdge.draw();
        rightEdge.draw();
        upperEdge.draw();
        lowerEdge.draw();
        tableHoles.draw();
        tableLegs.draw();

        if (gameStarted) {
            moveBalls();
        } else {
            gameStarted = true;
            placeBalls();
        }


        game.popMatrix();


    }

    private void moveBalls() {
        whiteBall.move();
    }

    private void placeBalls() {
        whiteBall.init(new PVector((tableTab.getUpperLeftCoordinate().x + tableTab.getLowerRightCoordinate().x) / 2, (tableTab.getUpperLeftCoordinate().y + tableTab.getLowerRightCoordinate().y) / 2, tableTab.getUpperLeftCoordinate().z + BALL_RADIUS));



    }


}
