package shapes.table;


import main.Game;
import processing.core.PVector;
import shapes.Ball;
import shapes.Shape;
import util.Balls;

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


    private final Balls balls;


    public Table(Game game) {
        super(game);
        tableHoles = new TableHoles(game);
        tableTab = new TableTab(game);
        leftEdge = new LeftEdge(game);
        rightEdge = new RightEdge(game);
        upperEdge = new UpperEdge(game);
        lowerEdge = new LowerEdge(game);
        tableLegs = new TableLegs(game);




        balls=new Balls(game,this);
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
            balls.moveBalls();
        } else {
            gameStarted = true;
            balls.placeBalls();
        }


        game.popMatrix();


    }

    public TableTab getTableTab() {
        return tableTab;
    }
}
