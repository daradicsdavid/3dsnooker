package shapes.table;

import main.Game;
import processing.core.PImage;
import processing.core.PShape;
import shapes.Shape;

import static constants.TableConstants.*;

public class TableHoles extends Shape {
    private final PImage holeTexture;

    public TableHoles(Game game) {
        super(game);
        holeTexture = game.loadImage("hole.png");
    }

    public void draw() {
        drawUpperLeftHole();
        drawMiddleLeftHole();
        drawLowerLeftHole();

        drawUpperRightHole();
        drawMiddleRightHole();
        drawLowerRightHole();
        
    }

    private void drawUpperLeftHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(0, 0, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(0, TABLE_HOLE_WIDTH, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, TABLE_HOLE_WIDTH, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, 0, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

    private void drawMiddleLeftHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(0, TABLE_WIDTH / 2 - TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, TABLE_WIDTH / 2 - TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, TABLE_WIDTH / 2 + TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(0, TABLE_WIDTH / 2 + TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

    private void drawLowerLeftHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(0, TABLE_WIDTH - TABLE_HOLE_WIDTH, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(0, TABLE_WIDTH, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, TABLE_WIDTH, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(TABLE_HOLE_WIDTH, TABLE_WIDTH - TABLE_HOLE_WIDTH, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

    private void drawUpperRightHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, 0, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, TABLE_HOLE_WIDTH, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT, TABLE_HOLE_WIDTH, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT, 0, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

    private void drawMiddleRightHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, TABLE_WIDTH / 2 - TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(TABLE_HEIGHT, TABLE_WIDTH / 2 - TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT, TABLE_WIDTH / 2 + TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, TABLE_WIDTH / 2 + TABLE_HOLE_WIDTH / 2, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

    private void drawLowerRightHole() {
        PShape upperLeftHole = game.createShape();
        upperLeftHole.beginShape();
        upperLeftHole.texture(holeTexture);

        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, TABLE_WIDTH - TABLE_HOLE_WIDTH, TABLE_DEPTH, 0, 0);
        upperLeftHole.vertex(TABLE_HEIGHT - TABLE_HOLE_WIDTH, TABLE_WIDTH, TABLE_DEPTH, 0, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT, TABLE_WIDTH, TABLE_DEPTH, holeTexture.height, holeTexture.width);
        upperLeftHole.vertex(TABLE_HEIGHT, TABLE_WIDTH - TABLE_HOLE_WIDTH, TABLE_DEPTH, holeTexture.height, 0);
        upperLeftHole.endShape();
        game.shape(upperLeftHole);
    }

}
