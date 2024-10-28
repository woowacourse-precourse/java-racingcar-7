package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.parser.RacingCarParser;
import racingcar.view.InputView;

public class GameController {

    public static void run() {
        RacingGame racingGame = inputData();
        racingGame.play();
        racingGame.resultWinner();
    }

    private static RacingGame inputData() {
        String inputName = InputView.inputName();

        List<RacingCar> racingCarList = RacingCarParser.createRacingCarList(inputName);
        int tryCount = InputView.inputTryCount();

        return new RacingGame(racingCarList, tryCount);
    }
}
