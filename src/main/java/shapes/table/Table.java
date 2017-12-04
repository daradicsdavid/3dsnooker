package shapes.table;


import main.Game;
import processing.core.PConstants;
import processing.event.MouseEvent;
import shapes.CueStick;
import shapes.Shape;
import util.Balls;
import util.Timer;

import static constants.TableConstants.TABLE_HEIGHT;
import static constants.TableConstants.TABLE_WIDTH;


public class Table extends Shape {


    boolean gameStarted = false;

    private final TableHoles tableHoles;
    private final TableTab tableTab;
    private final LeftEdge leftEdge;
    private final RightEdge rightEdge;
    private final UpperEdge upperEdge;
    private final LowerEdge lowerEdge;
    private final TableLegs tableLegs;
    private final CueStick cueStick;


    private final Balls balls;
    private final Timer timer;
    private float cameraDistance;

    public Table(Game game) {
        super(game);
        tableHoles = new TableHoles(game);
        tableTab = new TableTab(game);
        leftEdge = new LeftEdge(game);
        rightEdge = new RightEdge(game);
        upperEdge = new UpperEdge(game);
        lowerEdge = new LowerEdge(game);
        tableLegs = new TableLegs(game);
        balls = new Balls(game, this);

        cueStick = new CueStick(game, balls.getWhiteBall());


        timer = new Timer(game, cueStick);
        cameraDistance = (game.height / 2) / game.tan((game.PI * 30 / 180));
    }

    public void draw() {
        if (gameStarted && !balls.anyBallStillMoving() && !cueStick.isInMovement()) {
            timer.showTimer();
        }
        game.pushMatrix();
        setCamera();
        game.translate(game.width / 2 - TABLE_HEIGHT / 2, game.height / 2 - TABLE_WIDTH / 2);
        game.rotateX(PConstants.QUARTER_PI);
        tableTab.draw();
        leftEdge.draw();
        rightEdge.draw();
        upperEdge.draw();
        lowerEdge.draw();
        tableHoles.draw();
        tableLegs.draw();

        if (gameStarted) {
            if (balls.anyBallStillMoving()) {
                balls.moveBalls();
            } else {
                cueStick.draw();
            }
        } else {
            gameStarted = true;
            balls.placeBalls();
        }

        balls.drawBalls();

        game.popMatrix();


    }

    private void setCamera() {
        game.camera(game.width / 2, game.height / 2, cameraDistance, game.width / 2, game.height / 2, 0, 0, 1, 0);
    }


    public TableTab getTableTab() {
        return tableTab;
    }

    public void zoomCamera(MouseEvent event) {
        cameraDistance += event.getCount()*50;
    }
}
