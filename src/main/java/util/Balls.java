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
    //First row
    private final Ball yellowBall;
    //Second row
    private final Ball redBall;
    private final Ball blueBall;
    //Third row
    private final Ball greenBall;
    private final Ball orangeBall;
    private final Ball purpleBall;
    //Fourth row
    private final Ball cyanBall;
    private final Ball magentaBall;
    private final Ball limeBall;
    private final Ball pinkBall;

    private final List<Ball> balls = new ArrayList<Ball>();

    public Balls(Game game, Table table) {

        this.game = game;
        this.table = table;
        this.tab = table.getTableTab();

        whiteBall = new Ball(game, tab, 255, 255, 255);

        yellowBall = new Ball(game, tab, 255, 225, 25);

        redBall = new Ball(game, tab, 230, 25, 75);
        blueBall = new Ball(game, tab, 0, 130, 200);

        greenBall = new Ball(game, tab, 60, 180, 75);
        orangeBall = new Ball(game, tab, 245, 130, 48);
        purpleBall = new Ball(game, tab, 145, 30, 180);

        cyanBall = new Ball(game, tab, 70, 240, 240);
        magentaBall = new Ball(game, tab, 240, 50, 230);
        limeBall = new Ball(game, tab, 210, 245, 60);
        pinkBall = new Ball(game, tab, 250, 190, 190);

        balls.add(whiteBall);

        balls.add(yellowBall);

        balls.add(redBall);
        balls.add(blueBall);

        balls.add(greenBall);
        balls.add(orangeBall);
        balls.add(purpleBall);

        balls.add(cyanBall);
        balls.add(magentaBall);
        balls.add(limeBall);
        balls.add(pinkBall);
    }

    public void moveBalls() {
        for (Ball ball : balls) {
            ball.initBallForMoving();
        }
        while (anyBallStillMovingInTurn()) {
            int collisionIterationThreshold = 100;
            while (anyBallColliding() && collisionIterationThreshold > 0) {
                for (Ball ball : balls) {
                    ball.checkCollisions(balls);
                }
                collisionIterationThreshold--;
            }
            for (Ball ball : balls) {
                ball.move();
            }
        }
        for (Ball ball : balls) {
            ball.decreaseSpeedBy(2);
        }
    }

    private boolean anyBallColliding() {
        for (Ball ball : balls) {
            if (ball.isCollidingWithAnyThing(balls)) {
                return true;
            }
        }
        return false;
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

        initializeRedBall();
        initializeBlueBall();

        initializeGreenBall();
        initializeOrangeBall();
        initializePurpleBall();

        initializeCyanBall();
        initializeMagentaBall();
        initializeLimeBall();
        initializePinkBall();
    }

    private void initializePinkBall() {
        PVector limeBallCenterPoint = limeBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(limeBallCenterPoint.x + BALL_RADIUS * 2, limeBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        pinkBall.init(initialPoint);
    }

    private void initializeLimeBall() {
        PVector magentaBallCenterPoint = magentaBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(magentaBallCenterPoint.x + BALL_RADIUS * 2, magentaBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        limeBall.init(initialPoint);
    }

    private void initializeMagentaBall() {
        PVector cyanBallCenterPoint = cyanBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(cyanBallCenterPoint.x + BALL_RADIUS * 2, cyanBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        magentaBall.init(initialPoint);
    }

    private void initializeCyanBall() {
        PVector greenBallCenterPoint = greenBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(greenBallCenterPoint.x - BALL_RADIUS, greenBallCenterPoint.y - 2 * BALL_RADIUS - 2, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        cyanBall.init(initialPoint);
    }

    private void initializePurpleBall() {
        PVector orangeBallCenterPoint = orangeBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(orangeBallCenterPoint.x + BALL_RADIUS * 2, orangeBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        purpleBall.init(initialPoint);

    }

    private void initializeOrangeBall() {
        PVector greenBallCenterPoint = greenBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(greenBallCenterPoint.x + BALL_RADIUS * 2, greenBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        orangeBall.init(initialPoint);
    }

    private void initializeGreenBall() {
        PVector redBallCenterPoint = redBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(redBallCenterPoint.x - BALL_RADIUS, redBallCenterPoint.y - 2 * BALL_RADIUS - 2, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        greenBall.init(initialPoint);
    }

    private void initializeBlueBall() {
        PVector redBallCenterPoint = redBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(redBallCenterPoint.x + BALL_RADIUS * 2, redBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        blueBall.init(initialPoint);
    }

    private void initializeRedBall() {
        PVector yellowCenterPoint = yellowBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(yellowCenterPoint.x - BALL_RADIUS, yellowCenterPoint.y - 2 * BALL_RADIUS - 2, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        redBall.init(initialPoint);
    }

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
