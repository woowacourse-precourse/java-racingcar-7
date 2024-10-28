package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNames = InputHandler.getCarNames();
        int totalRaceRound = InputHandler.getTotalRaceCount();

        RacingGame racingGame = new RacingGame(carNames, totalRaceRound);
        racingGame.start();
    }
}
