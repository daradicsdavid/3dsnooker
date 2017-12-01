package shapes;

import main.Game;
import processing.core.PShape;
import processing.core.PVector;

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

    public CueStick(Game game, Ball whiteBall) {
        super(game);
        this.whiteBall = whiteBall;
    }

    public void draw() {
        if (game.keyPressed) {
            rotateCueStickByKeyPressed();
        }

        game.pushMatrix();
        PVector centerPoint = whiteBall.getCenterPoint();
        game.translate(centerPoint.x, centerPoint.y, centerPoint.z);
        game.rotateX(HALF_PI);

        game.rotateY(angleToBall);


        drawCueStick();

        game.popMatrix();

    }

    private void rotateCueStickByKeyPressed() {
        if (game.key == CODED) {
            switch (game.keyCode) {
                case LEFT:
                    angleToBall += 0.1;
                    break;
                case RIGHT:
                    angleToBall -= 0.1;
                    break;
            }
        }
    }

    void drawCueStick() {
        PShape tip = game.createShape();
        float angle = 1;
        float sides = 360;
        // top
        tip.beginShape();
        tip.fill(139, 90, 43);
        tip.noStroke();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            float y = sin(radians(i * angle)) * CUE_STICK_TIP_RADIUS;
            tip.vertex(x, y, 0);
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
            bumper.vertex(x, y, -CUE_STICK_LENGTH);
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
            cueStickBody.vertex(x1, y1, 0);
            cueStickBody.vertex(x2, y2, -CUE_STICK_LENGTH);
        }
        cueStickBody.endShape(CLOSE);
        game.shape(cueStickBody);
    }
}
