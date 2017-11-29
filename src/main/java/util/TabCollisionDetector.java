package util;

import processing.core.PVector;
import shapes.Ball;
import shapes.table.TableTab;


import static constants.TableConstants.*;
import static util.DetectedEdge.*;

public class TabCollisionDetector {

    private final TableTab tab;
    private final Ball ball;


    public TabCollisionDetector(TableTab tab, Ball ball) {
        this.tab = tab;
        this.ball = ball;


    }

    public DetectedEdge detectCollision() {

        if (checkUpperEdge()) return UPPER_EDGE;
        if (checkLowerEdge()) return LOWER_EDGE;
        if (checkLeftEdge()) return LEFT_EDGE;
        if (checkRightEdge()) return RIGHT_EDGE;


        return NONE;
    }

    private boolean checkRightEdge() {
        return getNextBallCenter().x + BALL_RADIUS >= TABLE_HEIGHT;
    }

    private boolean checkLeftEdge() {
        return getNextBallCenter().x - BALL_RADIUS <= 0;
    }

    private boolean checkLowerEdge() {
        return getNextBallCenter().y + BALL_RADIUS >= TABLE_WIDTH;
    }

    private boolean checkUpperEdge() {
        return getNextBallCenter().y - BALL_RADIUS <= 0;
    }

    private PVector getNextBallCenter() {
        return ball.getCenterPoint().copy().add(ball.getNextMovement());
    }

}
