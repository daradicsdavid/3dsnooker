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
    private final Ball yellowBall;
   /* private final Ball redBall;
    private final Ball yellowBall2;*/

    private final List<Ball> balls = new ArrayList<Ball>();

    public Balls(Game game, Table table) {

        this.game = game;
        this.table = table;
        this.tab = table.getTableTab();

        whiteBall = new Ball(game, tab, 255, 255, 255);
        yellowBall = new Ball(game, tab, 247, 202, 24);
      /*  redBall = new Ball(game, tab, 255, 0, 0);
        yellowBall2 = new Ball(game, tab, 244, 208, 63);*/

        balls.add(whiteBall);
        balls.add(yellowBall);
        /*balls.add(redBall);
        balls.add(yellowBall2);*/
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
                ball.calculateNewTrajectoryBasedOnCollisions();
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
        initializeYellowBall();
      /*  initializeRedBall();
        initializeYellowBall2();*/
    }

   /* private void initializeYellowBall2() {
        PVector redBallCenterPoint = redBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(redBallCenterPoint.x + BALL_RADIUS * 2, redBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        yellowBall2.init(initialPoint);
    }

    private void initializeRedBall() {
        PVector yellowCenterPoint = yellowBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(yellowCenterPoint.x - BALL_RADIUS, yellowCenterPoint.y - 2 * BALL_RADIUS - 1, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        redBall.init(initialPoint);
    }*/

    private void initializeYellowBall() {
        PVector initialPoint = new PVector(TABLE_HEIGHT / 2, TABLE_WIDTH / 4, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        yellowBall.init(initialPoint);
    }


    private void initializeWhiteBall() {
        PVector initialPoint = new PVector(TABLE_HEIGHT / 2, TABLE_WIDTH - TABLE_WIDTH / 4, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
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
