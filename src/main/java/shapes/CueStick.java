package shapes;

import main.Game;
import processing.core.PShape;
import processing.core.PVector;
import util.Timer;

import static constants.TableConstants.CUE_STICK_BUMBER_RADIUS;
import static constants.TableConstants.CUE_STICK_LENGTH;
import static constants.TableConstants.CUE_STICK_TIP_RADIUS;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.*;

public class CueStick extends Shape {

    private final Ball whiteBall;

    private float angleToBall = 0;
    private float distanceFromBall = 0;

    private boolean inMovement = false;
    private float distanceFromBallInMovement = 0;
    private float backWardMovementDistance;
    private boolean backWardMovementDone;
    private boolean move;
    private Timer timer;

    public CueStick(Game game, Ball whiteBall) {
        super(game);
        this.whiteBall = whiteBall;
    }

    public void draw() {
        isCueStickStarted();

        if (!inMovement && game.keyPressed) {
            timer.resetTimer();
            rotateCueStickByKeyPressed();
        }

        game.pushMatrix();
        PVector centerPoint = whiteBall.getCenterPoint();
        game.translate(centerPoint.x, centerPoint.y, centerPoint.z);
        game.rotateX(HALF_PI + QUARTER_PI / 8);

        game.rotateY(angleToBall);

        if (inMovement) {
            calculateNextDistanceFromBall();
        }

        drawCueStick();


        game.popMatrix();
    }

    private void calculateNextDistanceFromBall() {
        if (distanceFromBallInMovement < backWardMovementDistance && !backWardMovementDone) {
            distanceFromBallInMovement += distanceFromBall / 16;
        } else {
            backWardMovementDone = true;
            if (distanceFromBallInMovement > distanceFromBall / 3) {
                distanceFromBallInMovement -= distanceFromBall / 3;
            } else {
                inMovement = false;
                startWhiteBall();
            }
        }
    }

    private void isCueStickStarted() {
        if ((game.keyPressed && game.key == CODED && game.keyCode == CONTROL) || move && !inMovement) {
            inMovement = true;
            move = false;
            backWardMovementDone = false;
            distanceFromBallInMovement = distanceFromBall;
            backWardMovementDistance = distanceFromBall + distanceFromBall / 4;
        }
    }

    private void rotateCueStickByKeyPressed() {
        if (game.key == CODED) {
            switch (game.keyCode) {
                case LEFT:
                    angleToBall += PI / 180;
                    break;
                case RIGHT:
                    angleToBall -= PI / 180;
                    break;
                case UP:
                    if (distanceFromBall > 0) {
                        distanceFromBall -= 2;
                    } else {
                        distanceFromBall = 0;
                    }
                    break;
                case DOWN:
                    distanceFromBall += 2;
                    break;
            }
        }
    }

    private void startWhiteBall() {
        float angle = (float) (angleToBall - TWO_PI * Math.floor((angleToBall + Math.PI) / TWO_PI));
        angle -= HALF_PI;
        PVector direction = new PVector(cos(angle), sin(angle));
        whiteBall.initBallForMoving(direction.mult(getSpeedFromDistance()));
    }

    private float getSpeedFromDistance() {
        return distanceFromBall / 3;
    }

    void drawCueStick() {
        float angle = 1;
        float sides = 360;
        float distanceFromBall = inMovement ? distanceFromBallInMovement : this.distanceFromBall;
        // top
        PShape tip = game.createShape();
        tip.beginShape();
        tip.fill(139, 90, 43);
        tip.noStroke();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            float y = sin(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            tip.vertex(x, y, -distanceFromBall);
        }
        tip.endShape(CLOSE);
        game.shape(tip);
        // bottom
        PShape bumper = game.createShape();
        bumper.beginShape();
        bumper.fill(139, 90, 43);
        bumper.noStroke();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * CUE_STICK_BUMBER_RADIUS;
            float y = sin(radians(i * angle)) * CUE_STICK_BUMBER_RADIUS;
            bumper.vertex(x, y, -CUE_STICK_LENGTH - distanceFromBall);
        }
        bumper.endShape(CLOSE);
        game.shape(bumper);
        // draw body
        PShape cueStickBody = game.createShape();
        cueStickBody.beginShape(TRIANGLE_STRIP);
        cueStickBody.fill(139, 90, 43);
        cueStickBody.noStroke();
        for (int i = 0; i < sides + 1; i++) {
            float x1 = cos(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            float y1 = sin(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            float x2 = cos(radians(i * angle)) * CUE_STICK_BUMBER_RADIUS;
            float y2 = sin(radians(i * angle)) * CUE_STICK_BUMBER_RADIUS;
            cueStickBody.vertex(x1, y1, -distanceFromBall);
            cueStickBody.vertex(x2, y2, -CUE_STICK_LENGTH - distanceFromBall);
        }
        cueStickBody.endShape(CLOSE);
        game.shape(cueStickBody);
    }

    public void move() {
        move = true;
    }

    public boolean isInMovement() {
        return inMovement;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
