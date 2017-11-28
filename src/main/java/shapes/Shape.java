package shapes;


import main.Game;
import processing.core.PShape;

public abstract class Shape {
    protected final Game game;
    public Shape(Game game) {
        this.game = game;
    }

    public abstract void draw();

}
