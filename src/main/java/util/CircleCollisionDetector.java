package util;

import processing.core.PVector;
import shapes.Ball;

import static constants.TableConstants.BALL_RADIUS;

public class CircleCollisionDetector {
    public static boolean isColliding(Ball ball1, Ball ball2) {
        PVector ball1NextCenterPoint = ball1.getCenterPoint().copy().add(ball1.getDirection());
        PVector ball2NextCenterPoint = ball2.getCenterPoint().copy().add(ball2.getDirection());
        float dx = ball1NextCenterPoint.x - ball2NextCenterPoint.x;
        float dy = ball1NextCenterPoint.y - ball2NextCenterPoint.y;
        float radii = BALL_RADIUS * 2;
        if ((dx * dx) + (dy * dy) < radii * radii) {
            return true;
        } else {
            return false;
        }
    }
}
