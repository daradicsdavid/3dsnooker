import main.Game;
import processing.core.PApplet;
import shapes.Table;

public class App extends PApplet {



    public static void main(String[] args) {
        String[] processingArgs = {"Game"};
        Game game = new Game();
        PApplet.runSketch(processingArgs, game);
    }

}
