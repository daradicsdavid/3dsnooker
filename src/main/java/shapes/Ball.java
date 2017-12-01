package shapes;

import main.Game;
import processing.core.PVector;
import shapes.table.TableTab;
import util.DetectedEdge;
import util.TabCollisionDetector;

import java.util.ArrayList;
import java.util.List;

import static constants.TableConstants.BALL_RADIUS;
import static constants.TableConstants.SPEED_THRESHOLD;
import static processing.core.PApplet.sqrt;
import static util.CircleCollisionDetector.isColliding;

public class Ball extends Shape {

    private final TableTab tab;
    PVector centerPoint;
    float speed = 20;
    float speedForTurn;
    List<Ball> alreadyManagedCollisionWith;
    PVector direction;
    private float r;
    private float g;
    private float b;

    public Ball(Game game, TableTab tab, float r, float g, float b) {
        super(game);
        this.tab = tab;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void draw() {
        game.pushMatrix();
        game.translate(centerPoint.x, centerPoint.y, centerPoint.z);
        game.fill(r, g, b);
        game.noStroke();
        game.sphere(BALL_RADIUS);
        game.popMatrix();
    }

    public void checkCollisions(List<Ball> balls) {
        checkIfCollidingWithTabEdge();
        checkIfCollidingWithOtherBall(balls);
    }

    private void checkIfCollidingWithOtherBall(List<Ball> balls) {
        for (Ball ball : balls) {
            if (!ball.equals(this) && isColliding(ball, this) && !alreadyManagedCollisionWith.contains(ball)) {
                manageColliding(ball);
            }
        }
    }

    private void manageColliding(Ball ball) {
        PVector distance = new PVector(centerPoint.x - ball.centerPoint.x, centerPoint.y - ball.centerPoint.y);
        distance.normalize();

        float a1 = getSpeedVector().dot(distance);
        float a2 = ball.getSpeedVector().dot(distance);

        float optimizedP = (float) ((2.0 * (a1 - a2)) / 2);

        distance.mult(optimizedP);


        addNewTrajectoryVectorToDirection(distance.copy().mult(-1));

        ball.addNewTrajectoryVectorToDirection(distance);

        decreaseSpeedBy(2);
        ball.decreaseSpeedBy(2);

        alreadyManagedCollisionWith.add(ball);
        ball.alreadyManagedCollisionWith.add(this);


    }

    private void addNewTrajectoryVectorToDirection(PVector distance) {
        direction.add(distance);
        speed = getLength(direction);
        speedForTurn = getLength(direction);
        direction.normalize();
    }

    private float getLength(PVector direction) {
        return sqrt(direction.x * direction.x + direction.y * direction.y);
    }

    private PVector getSpeedVector() {
        return direction.copy().mult(speed);
    }

    private void checkIfCollidingWithTabEdge() {
        TabCollisionDetector tabCollisionDetector = new TabCollisionDetector(tab, this);
        DetectedEdge detectedEdge = tabCollisionDetector.detectCollision();
        if (detectedEdge != DetectedEdge.NONE) {
            decreaseSpeedBy(3);
            invertDirection();
        }
        switch (detectedEdge) {
            case UPPER_EDGE:
            case LOWER_EDGE:
                direction.x *= -1;
                break;
            case LEFT_EDGE:
            case RIGHT_EDGE:
                direction.y *= -1;
        }
    }

    public void move() {
        if (speedForTurn >= 1) {
            centerPoint.add(direction);
            speedForTurn--;
        } else {
            centerPoint.add(direction.copy().mult(speedForTurn));
            speedForTurn = 0;
        }
    }


    private void invertDirection() {
        direction.x *= -1;
        direction.y *= -1;
    }


    public PVector getCenterPoint() {
        return centerPoint;
    }


    public void init(PVector centerPoint, PVector initialDirection) {
        direction = initialDirection;
        direction.normalize();
        this.centerPoint = centerPoint;

        draw();
    }

    public void decreaseSpeedBy(int percentage) {
        speed = speed / 100 * (100 - percentage);
        speedForTurn = speedForTurn / 100 * (100 - percentage);
        if (speed < SPEED_THRESHOLD) {
            speed = 0;
        }
    }

    public void initBallForMoving() {
        speedForTurn = speed;
        alreadyManagedCollisionWith = new ArrayList<Ball>();
    }

    public boolean isStillMoving() {
        return speedForTurn != 0;
    }

    public PVector getDirection() {
        return direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (Float.compare(ball.r, r) != 0) return false;
        if (Float.compare(ball.g, g) != 0) return false;
        return Float.compare(ball.b, b) == 0;
    }

    @Override
    public int hashCode() {
        int result = (r != +0.0f ? Float.floatToIntBits(r) : 0);
        result = 31 * result + (g != +0.0f ? Float.floatToIntBits(g) : 0);
        result = 31 * result + (b != +0.0f ? Float.floatToIntBits(b) : 0);
        return result;
    }
}
