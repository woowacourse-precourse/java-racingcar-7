package racingcar;

import racingcar.domain.RacingGame;

public class Application {

    public static void main(String[] args) {
        RacingGame game = RacingGame.createFromInput();
        game.play();
    }
}
