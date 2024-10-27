package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        RacingIO.promptCarNamesInput();
        String carNameInput = RacingIO.getInput();

        RacingIO.promptMoveCountInput();
        int moveCountInput = Integer.parseInt(RacingIO.getInput());

        RacingService racingService = new RacingService(carNameInput, moveCountInput);
        racingService.startRaceGame();

        ArrayList<HashMap<String, Integer>> turnResults = racingService.getTurnResult();
        RacingIO.promptTurnResult(turnResults);
    }
}
