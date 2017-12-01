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

    private final List<Ball> balls = new ArrayList<Ball>();

    public Balls(Game game, Table table) {

        this.game = game;
        this.table = table;
        this.tab = table.getTableTab();

        whiteBall = new Ball(game, tab, 255, 255, 255);

        balls.add(whiteBall);
    }

    public void moveBalls() {
        for (Ball ball : balls) {
            ball.initBallForMoving();
        }
        while (anyBallStillMovingInTurn()) {
            for (Ball ball : balls) {
                ball.checkCollisions(balls);
            }
            for (Ball ball : balls) {
                ball.move();
            }
        }
        for (Ball ball : balls) {
            ball.decreaseSpeedBy(2);
        }
    }

    public boolean anyBallStillMovingInTurn() {
        for (Ball ball : balls) {
            if (ball.isStillMovingInTurn()) {
                return true;
            }
        }
        return false;
    }

    public boolean anyBallStillMoving() {
        for (Ball ball : balls) {
            if (ball.isStillMoving()) {
                return true;
            }
        }
        return false;
    }

    public void placeBalls() {
        initializeWhiteBall();
    }


    private void initializeWhiteBall() {
        PVector initialPoint = new PVector(TABLE_HEIGHT / 2, TABLE_WIDTH / 2, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        whiteBall.init(initialPoint);
    }


    public Ball getWhiteBall() {
        return whiteBall;
    }

    public void drawBalls() {
        for (Ball ball : balls) {
            ball.draw();
        }
    }
}
