package util;

import shapes.Ball;

import static constants.TableConstants.BALL_RADIUS;

public class CircleCollisionDetector {
    public static boolean isColliding(Ball ball1, Ball ball2) {
        float dx = ball1.getCenterPoint().x - ball2.getCenterPoint().x;
        float dy = ball1.getCenterPoint().y - ball2.getCenterPoint().y;
        float radii = BALL_RADIUS * 2;
        return (dx * dx) + (dy * dy) <= radii * radii;
    }
}
