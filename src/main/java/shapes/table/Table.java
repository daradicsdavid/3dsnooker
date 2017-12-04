package shapes.table;


import main.Game;
import shapes.CueStick;
import shapes.Shape;
import util.Balls;
import util.Timer;


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

    }

    public void draw() {
        if (gameStarted && !balls.anyBallStillMoving() && !cueStick.isInMovement()) {
            timer.showTimer();
        }
        game.pushMatrix();
        game.translate(game.width / 5, game.height / 5);
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


    public TableTab getTableTab() {
        return tableTab;
    }
}
