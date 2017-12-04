package util;

import main.Game;
import shapes.CueStick;

public class Timer {

    int time;
    int wait = 1000;
    int interval = 11;

    private final Game game;
    private final CueStick cueStick;

    public Timer(Game game, CueStick cueStick) {

        this.game = game;
        this.cueStick = cueStick;
        time = game.millis();
        cueStick.setTimer(this);
    }

    public void showTimer() {
        if (interval != 11) {
            game.textSize(32);
            game.text(interval, 40, 40);
        }
        if (game.millis() - time >= wait) {
            interval--;
            if (interval < 0) {
                cueStick.move();
                interval = 10;
            }
            time = game.millis();//also update the stored time
        }
    }

    public void resetTimer() {
        interval = 11;
    }
}
