package shapes;

import main.Game;
import physics.CollisionPhysics;
import physics.CollisionResponse;
import physics.CollisionType;
import processing.core.PVector;

import static constants.TableConstants.*;
import static physics.CollisionType.BALL;
import static physics.CollisionType.NONE;
import static physics.CollisionType.WALL;
import static processing.core.PApplet.abs;

public class Ball extends Shape {

    float x, y, z;
    float speedX, speedY;
    private float r;
    private float g;
    private float b;

    public CollisionResponse earliestCollisionResponse = new CollisionResponse();
    private CollisionType collisionType;

    public Ball(Game game, float r, float g, float b) {
        super(game);
        this.r = r;
        this.g = g;
        this.b = b;
        collisionType = NONE;
    }

    public void draw() {
        game.pushMatrix();
        game.translate(x, y, z);
        game.fill(r, g, b);
        game.noStroke();
        game.sphere(BALL_RADIUS);
        game.popMatrix();
    }

    public void init(PVector centerPoint) {
        x = centerPoint.x;
        y = centerPoint.y;
        z = centerPoint.z;
    }

    private CollisionResponse tempResponse = new CollisionResponse();

    public void intersect(float timeLimit) {
        CollisionPhysics.pointIntersectsRectangleOuter(x, y, speedX, speedY, BALL_RADIUS,
                0, 0, TABLE_HEIGHT, TABLE_WIDTH, timeLimit, tempResponse);
        if (tempResponse.t < earliestCollisionResponse.t) {
            earliestCollisionResponse.copy(tempResponse);
            setCollisionType(WALL);
        }
    }


    private CollisionResponse thisResponse = new CollisionResponse();
    private CollisionResponse anotherResponse = new CollisionResponse();

    public void intersect(Ball another, float timeLimit) {
        CollisionPhysics.pointIntersectsMovingPoint(
                this.x, this.y, this.speedX, this.speedY, BALL_RADIUS,
                another.x, another.y, another.speedX, another.speedY, BALL_RADIUS,
                timeLimit, thisResponse, anotherResponse);

        if (anotherResponse.t < another.earliestCollisionResponse.t) {
            another.earliestCollisionResponse.copy(anotherResponse);
            setCollisionType(BALL);
        }
        if (thisResponse.t < this.earliestCollisionResponse.t) {
            this.earliestCollisionResponse.copy(thisResponse);
            setCollisionType(BALL);
        }
    }

    public void update(float time) {
        if (earliestCollisionResponse.t <= time) {
            this.x = earliestCollisionResponse.getNewX(this.x, this.speedX);
            this.y = earliestCollisionResponse.getNewY(this.y, this.speedY);
            this.speedX = earliestCollisionResponse.newSpeedX;
            this.speedY = earliestCollisionResponse.newSpeedY;
        } else {
            this.x += this.speedX * time;
            this.y += this.speedY * time;
        }
        earliestCollisionResponse.reset();
    }

    public boolean isStillMoving() {
        return speedX != 0 || speedY != 0;
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

    public PVector getCenterPoint() {
        return new PVector(x, y, z);
    }


    public void initBallForMoving(PVector speed) {
        speedX = speed.x;
        speedY = speed.y;
    }

    public void slowBallByPercent(int percent) {
        speedX = speedX / 100 * (100 - percent);
        speedY = speedY / 100 * (100 - percent);
        if (abs(speedX) < SPEED_THRESHOLD && abs(speedY) < SPEED_THRESHOLD) {
            speedX = 0;
            speedY = 0;
        }
    }

    public void setCollisionType(CollisionType collisionType) {
        this.collisionType = collisionType;
    }

    public void slowBallAfterTurn() {
        int slowPercent = 2;
        switch (collisionType) {
            case BALL:
                slowPercent += 2;
                break;
            case WALL:
                slowPercent += 3;
                break;
            case NONE:
                break;
        }
        slowBallByPercent(slowPercent);
        collisionType = NONE;
    }

    public float getSpeed() {
        return new PVector(speedX, speedY).mag();
    }
}
