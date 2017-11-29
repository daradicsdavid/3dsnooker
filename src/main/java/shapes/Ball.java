package shapes;

import main.Game;
import processing.core.PVector;
import shapes.table.TableTab;
import util.DetectedEdge;
import util.TabCollisionDetector;

import static constants.TableConstants.BALL_RADIUS;

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
            //TODO megnézni ez jó sebesség-e
            PVector direction = this.direction.copy().mult(speed);
            checkIfCollisionHappenedWithTabEdge();
            centerPoint.add(direction);
            speed = speed / 100 * 98;

        }

        draw();
    }

    private void checkIfCollisionHappenedWithTabEdge() {
        TabCollisionDetector tabCollisionDetector = new TabCollisionDetector(tab, this);
        DetectedEdge detectedEdge = tabCollisionDetector.detectCollision();
        if (detectedEdge != DetectedEdge.NONE) {
            speed = speed / 100 * 97;
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


    public void setCenterPoint(PVector centerPoint) {
        this.centerPoint = centerPoint;
    }

    public PVector getCenterPoint() {
        return centerPoint;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void init(PVector centerPoint) {
        direction = tab.getUpperRightCoordinate().sub(tab.getLowerRightCoordinate()).normalize();
        this.centerPoint = centerPoint;

        draw();
    }
}
