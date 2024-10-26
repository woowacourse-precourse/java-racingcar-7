package racingcar;

import racingcar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        new RacingGame(new RandomNumberGenerator()).start();
    }
}
