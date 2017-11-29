package util;

import main.Game;
import processing.core.PVector;
import shapes.Ball;
import shapes.table.Table;
import shapes.table.TableTab;

import java.util.ArrayList;
import java.util.List;

import static constants.TableConstants.BALL_RADIUS;
import static constants.TableConstants.TABLE_HEIGHT;
import static constants.TableConstants.TABLE_WIDTH;

public class Balls {
    private final Game game;
    private final Table table;
    private final TableTab tab;

    private final Ball whiteBall;
    private final Ball blackBall;

    private final List<Ball> balls = new ArrayList<Ball>();

    public Balls(Game game, Table table) {

        this.game = game;
        this.table = table;
        this.tab = table.getTableTab();

        whiteBall = new Ball(game, tab, 255, 255, 255);
        blackBall = new Ball(game, tab, 0, 0, 0);

        balls.add(whiteBall);
        balls.add(blackBall);
    }

    public void moveBalls() {
        for (Ball ball : balls) {
            ball.initBallForMoving();
        }
        while (anyBallStillMoving()) {
            for (Ball ball : balls) {
                ball.checkCollisions(balls);
            }
            for (Ball ball : balls) {
                ball.move();
            }
        }
        for (Ball ball : balls) {
            ball.decreaseSpeedBy(2);
            ball.draw();
            if (ball.getSpeed() == 0) {
                ball.setSpeed(20);
            }
        }
    }

    private boolean anyBallStillMoving() {
        for (Ball ball : balls) {
            if (ball.isStillMoving()) {
                return true;
            }
        }
        return false;
    }

    public void placeBalls() {
        PVector whiteBallPoint = new PVector(TABLE_HEIGHT / 2, 1 + BALL_RADIUS, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        PVector blackBallPoint = new PVector(TABLE_HEIGHT / 2, TABLE_WIDTH - BALL_RADIUS - 1, tab.getUpperLeftCoordinate().z + BALL_RADIUS);

        whiteBall.init(whiteBallPoint, tab.getUpperRightCoordinate().sub(tab.getLowerRightCoordinate()));
        blackBall.init(blackBallPoint, tab.getLowerRightCoordinate().sub(tab.getUpperRightCoordinate()));
    }
}
