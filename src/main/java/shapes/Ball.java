package shapes;

import main.Game;
import processing.core.PVector;
import shapes.table.TableTab;
import util.DetectedEdge;
import util.TabCollisionDetector;

import static constants.TableConstants.BALL_RADIUS;
import static constants.TableConstants.SPEED_THRESHOLD;

public class Ball extends Shape {

    PVector centerPoint;
    float speed = 20;
    PVector direction;

    private final TableTab tab;

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


    public void move() {
        if (speed > 0) {
            checkIfCollisionHappensWithTabEdge();

            centerPoint.add(getNextMovement());
            decreaseSpeedBy(2);

        } else {
            speed = 20;
        }
        draw();
    }

    public PVector getNextMovement() {
        return this.direction.copy().mult(speed);
    }

    private void checkIfCollisionHappensWithTabEdge() {
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

    private void invertDirection() {
        direction.x *= -1;
        direction.y *= -1;
    }


    public PVector getCenterPoint() {
        return centerPoint;
    }


    public void init(PVector centerPoint) {
        direction = tab.getUpperRightCoordinate().sub(tab.getUpperLeftCoordinate());
        direction.x -= 40;
        direction.y -= 40;
        direction.normalize();
        this.centerPoint = centerPoint;

        draw();
    }

    private void decreaseSpeedBy(int percentage) {
        speed = speed / 100 * (100 - percentage);
        if (speed < SPEED_THRESHOLD) {
            speed = 0;
        }
    }
}
