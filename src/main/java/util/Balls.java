package util;

import main.Game;
import processing.core.PVector;
import shapes.Ball;
import shapes.table.Table;
import shapes.table.TableTab;

import java.util.ArrayList;
import java.util.List;

import static constants.GameConstants.EPSILON_TIME;
import static constants.GameConstants.UPDATE_RATE;
import static constants.TableConstants.BALL_RADIUS;
import static constants.TableConstants.TABLE_HEIGHT;
import static constants.TableConstants.TABLE_WIDTH;

public class Balls {
    private final TableTab tab;

    private final Ball whiteBall;
    private final Ball yellowBall;
    private final Ball redBall;
    private final Ball blueBall;
    private final Ball greenBall;
    private final Ball orangeBall;
    private final Ball purpleBall;
    private final Ball cyanBall;
    private final Ball magentaBall;
    private final Ball limeBall;
    private final Ball pinkBall;

    private final Ball tealBall;
    private final Ball maroonBall;
    private final Ball mintBall;
    private final Ball coralBall;
    private final Ball navyBall;

    private final List<Ball> balls = new ArrayList<Ball>();

    public Balls(Game game, Table table) {
        this.tab = table.getTableTab();

        whiteBall = new Ball(game, 255, 255, 255);

        yellowBall = new Ball(game, 255, 225, 25);

        redBall = new Ball(game, 230, 25, 75);
        blueBall = new Ball(game, 0, 130, 200);

        greenBall = new Ball(game, 60, 180, 75);
        orangeBall = new Ball(game, 245, 130, 48);
        purpleBall = new Ball(game, 145, 30, 180);

        cyanBall = new Ball(game, 70, 240, 240);
        magentaBall = new Ball(game, 240, 50, 230);
        limeBall = new Ball(game, 210, 245, 60);
        pinkBall = new Ball(game, 250, 190, 190);

        tealBall = new Ball(game, 0, 128, 128);
        maroonBall = new Ball(game, 128, 0, 0);
        mintBall = new Ball(game, 170, 255, 195);
        coralBall = new Ball(game, 255, 215, 180);
        navyBall = new Ball(game, 0, 0, 128);

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

        balls.add(tealBall);
        balls.add(maroonBall);
        balls.add(mintBall);
        balls.add(coralBall);
        balls.add(navyBall);
    }

    public void moveBalls() {
        long beginTimeMillis, timeTakenMillis, timeLeftMillis;
        beginTimeMillis = System.currentTimeMillis();

        updateBalls();

        for (Ball ball : balls) {
            ball.slowBallAfterTurn();
            ball.draw();
        }

        timeTakenMillis = System.currentTimeMillis() - beginTimeMillis;
        timeLeftMillis = 1000L / UPDATE_RATE - timeTakenMillis;
        if (timeLeftMillis < 5) timeLeftMillis = 5;

        try {
            Thread.sleep(timeLeftMillis);
        } catch (InterruptedException ex) {
        }
    }

    private void updateBalls() {
        int currentNumBalls = balls.size();
        float timeLeft = 1.0f;

        do {
            float tMin = timeLeft;

            for (int i = 0; i < currentNumBalls; i++) {
                for (int j = 0; j < currentNumBalls; j++) {
                    if (i < j) {
                        balls.get(i).intersect(balls.get(j), tMin);
                        if (balls.get(i).earliestCollisionResponse.t < tMin) {
                            tMin = balls.get(i).earliestCollisionResponse.t;
                        }
                    }
                }
            }
            for (int i = 0; i < currentNumBalls; i++) {
                balls.get(i).intersect(tMin);
                if (balls.get(i).earliestCollisionResponse.t < tMin) {
                    tMin = balls.get(i).earliestCollisionResponse.t;
                }
            }

            for (int i = 0; i < currentNumBalls; i++) {
                balls.get(i).update(tMin);
            }

            timeLeft -= tMin;
        } while (timeLeft > EPSILON_TIME);
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

        initializeTealBall();
        initializeMaroonBall();
        initializeMintBall();
        initializeCoralBall();
        initializeNavyBall();
    }

    private void initializeNavyBall() {
        PVector coralBallCenterPoint = coralBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(coralBallCenterPoint.x + BALL_RADIUS * 2, coralBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        navyBall.init(initialPoint);
    }

    private void initializeCoralBall() {
        PVector mintBallCenterPoint = mintBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(mintBallCenterPoint.x + BALL_RADIUS * 2, mintBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        coralBall.init(initialPoint);
    }

    private void initializeMintBall() {
        PVector maroonBallCenterPoint = maroonBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(maroonBallCenterPoint.x + BALL_RADIUS * 2, maroonBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        mintBall.init(initialPoint);
    }

    private void initializeMaroonBall() {
        PVector tealBallCenterPoint = tealBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(tealBallCenterPoint.x + BALL_RADIUS * 2, tealBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        maroonBall.init(initialPoint);
    }

    private void initializeTealBall() {
        PVector cyanBallCenterPoint = cyanBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(cyanBallCenterPoint.x - BALL_RADIUS, cyanBallCenterPoint.y - 2 * BALL_RADIUS, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        tealBall.init(initialPoint);
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
        PVector initialPoint = new PVector(greenBallCenterPoint.x - BALL_RADIUS, greenBallCenterPoint.y - 2 * BALL_RADIUS, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
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
        PVector initialPoint = new PVector(redBallCenterPoint.x - BALL_RADIUS, redBallCenterPoint.y - 2 * BALL_RADIUS, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        greenBall.init(initialPoint);
    }

    private void initializeBlueBall() {
        PVector redBallCenterPoint = redBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(redBallCenterPoint.x + BALL_RADIUS * 2, redBallCenterPoint.y, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
        blueBall.init(initialPoint);
    }

    private void initializeRedBall() {
        PVector yellowCenterPoint = yellowBall.getCenterPoint().copy();
        PVector initialPoint = new PVector(yellowCenterPoint.x - BALL_RADIUS, yellowCenterPoint.y - 2 * BALL_RADIUS, tab.getUpperLeftCoordinate().z + BALL_RADIUS);
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

    public Ball getFastestMovingBall() {
        float speed = 0;
        Ball fastestBall = null;
        for (Ball ball : balls) {
            if (ball.getSpeed() > speed) {
                fastestBall = ball;
                speed = ball.getSpeed();
            }
        }
        return fastestBall;
    }
}
