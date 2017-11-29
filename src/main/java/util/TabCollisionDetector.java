package util;

import processing.core.PVector;
import shapes.Ball;
import shapes.table.TableTab;


import static constants.TableConstants.BALL_RADIUS;
import static constants.TableConstants.COLLISION_THRESHOLD;
import static processing.core.PApplet.abs;
import static processing.core.PApplet.reverse;
import static processing.core.PApplet.sqrt;
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
        return calculateDistance(tab.getUpperRightCoordinate(), tab.getLowerRightCoordinate()) < COLLISION_THRESHOLD;
    }

    private boolean checkLeftEdge() {
        return calculateDistance(tab.getUpperLeftCoordinate(), tab.getLowerLeftCoordinate()) < COLLISION_THRESHOLD;
    }

    private boolean checkLowerEdge() {
        return calculateDistance(tab.getLowerLeftCoordinate(), tab.getLowerRightCoordinate()) < COLLISION_THRESHOLD;
    }

    private boolean checkUpperEdge() {
        return calculateDistance(tab.getUpperLeftCoordinate(), tab.getUpperRightCoordinate()) < COLLISION_THRESHOLD;
    }

    private float calculateDistance(PVector coordinate1, PVector coordinate2) {
        float x0 = ball.getCenterPoint().x;
        float y0 = ball.getCenterPoint().y;

        float x1 = coordinate1.x;
        float y1 = coordinate1.y;

        float x2 = coordinate2.x;
        float y2 = coordinate2.y;

        float nominator = abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1);

        float denominator = sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

        float distance = nominator / denominator;

        distance -= BALL_RADIUS;

        return distance;
    }

}
