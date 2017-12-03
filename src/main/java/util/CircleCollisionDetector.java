package util;

import processing.core.PVector;
import shapes.Ball;

import static constants.TableConstants.BALL_RADIUS;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class CircleCollisionDetector {
    public static boolean isColliding(Ball ball1, Ball ball2) {
        PVector ball1CenterPoint = ball1.getCenterPoint().copy();
        PVector ball2CenterPoint = ball2.getCenterPoint().copy();
        ball1CenterPoint.z = 0;
        ball2CenterPoint.z = 0;

        // Get distances between the balls components
        PVector distanceVect = PVector.sub(ball2CenterPoint, ball1CenterPoint);

        // Calculate magnitude of the vector separating the balls
        float distanceVectMag = distanceVect.mag();

        // Minimum distance before they are touching
        float minDistance = BALL_RADIUS + BALL_RADIUS;

        return distanceVectMag < minDistance;
    }

    public static void manageColliding(Ball ball1, Ball ball2) {
        PVector ball1CenterPoint = ball1.getCenterPoint();
        PVector ball2CenterPoint = ball2.getCenterPoint();

        float m = BALL_RADIUS;

        PVector ball1SpeedVector = ball1.getSpeedVector();
        PVector ball2SpeedVector = ball2.getSpeedVector();

        // Get distances between the balls components
        PVector distanceVect = PVector.sub(ball2CenterPoint, ball1CenterPoint);

        // Calculate magnitude of the vector separating the balls
        float distanceVectMag = distanceVect.mag();
        float minDistance = BALL_RADIUS + BALL_RADIUS;

        float distanceCorrection = (float) ((minDistance - distanceVectMag) / 2.0);
        PVector d = distanceVect.copy();
        PVector correctionVector = d.normalize().mult(distanceCorrection);
        ball2.getCenterPoint().add(correctionVector);
        ball1.getCenterPoint().sub(correctionVector);


        // get angle of distanceVect
        float theta = distanceVect.heading();
        // precalculate trig values
        float sine = sin(theta);
        float cosine = cos(theta);

      /* bTemp will hold rotated ball positions. You
       just need to worry about bTemp[1] position*/
        PVector[] bTemp = {
                new PVector(), new PVector()
        };

      /* this ball's position is relative to the other
       so you can use the vector between them (bVect) as the
       reference point in the rotation expressions.
       bTemp[0].position.x and bTemp[0].position.y will initialize
       automatically to 0.0, which is what you want
       since b[1] will rotate around b[0] */
        bTemp[1].x = cosine * distanceVect.x + sine * distanceVect.y;
        bTemp[1].y = cosine * distanceVect.y - sine * distanceVect.x;

        // rotate Temporary velocities
        PVector[] vTemp = {
                new PVector(), new PVector()
        };

        vTemp[0].x = cosine * ball1SpeedVector.x + sine * ball1SpeedVector.y;
        vTemp[0].y = cosine * ball1SpeedVector.y - sine * ball1SpeedVector.x;
        vTemp[1].x = cosine * ball2SpeedVector.x + sine * ball2SpeedVector.y;
        vTemp[1].y = cosine * ball2SpeedVector.y - sine * ball2SpeedVector.x;

      /* Now that velocities are rotated, you can use 1D
       conservation of momentum equations to calculate
       the final velocity along the x-axis. */
        PVector[] vFinal = {
                new PVector(), new PVector()
        };

        // final rotated velocity for b[0]
        vFinal[0].x = ((m - m) * vTemp[0].x + 2 * m * vTemp[1].x) / (m + m);
        vFinal[0].y = vTemp[0].y;

        // final rotated velocity for b[0]
        vFinal[1].x = ((m - m) * vTemp[1].x + 2 * m * vTemp[0].x) / (m + m);
        vFinal[1].y = vTemp[1].y;

        // hack to avoid clumping
        bTemp[0].x += vFinal[0].x;
        bTemp[1].x += vFinal[1].x;

      /* Rotate ball positions and velocities back
       Reverse signs in trig expressions to rotate
       in the opposite direction */
        // rotate balls
        PVector[] bFinal = {
                new PVector(), new PVector()
        };

        bFinal[0].x = cosine * bTemp[0].x - sine * bTemp[0].y;
        bFinal[0].y = cosine * bTemp[0].y + sine * bTemp[0].x;
        bFinal[1].x = cosine * bTemp[1].x - sine * bTemp[1].y;
        bFinal[1].y = cosine * bTemp[1].y + sine * bTemp[1].x;

        // update balls to screen position
        ball2.getCenterPoint().x = ball1.getCenterPoint().x + bFinal[1].x;
        ball2.getCenterPoint().y = ball1.getCenterPoint().y + bFinal[1].y;

        ball1.getCenterPoint().add(bFinal[0]);

        // update velocities
        PVector newSpeedVector = new PVector();
        newSpeedVector.x = cosine * vFinal[0].x - sine * vFinal[0].y;
        newSpeedVector.y = cosine * vFinal[0].y + sine * vFinal[0].x;
        PVector otherBallNewSpeedVector = new PVector();
        otherBallNewSpeedVector.x = cosine * vFinal[1].x - sine * vFinal[1].y;
        otherBallNewSpeedVector.y = cosine * vFinal[1].y + sine * vFinal[1].x;

        ball1.setNewTrajectory(newSpeedVector);

        ball2.setNewTrajectory(otherBallNewSpeedVector);

        ball1.addManagedCollision(ball2);
        ball2.addManagedCollision(ball1);
    }
}
