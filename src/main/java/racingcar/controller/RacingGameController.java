package racingcar.controller;

import racingcar.model.CarScores;
import racingcar.model.RaceCount;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void runRacingGame() {
        OutputView.printCarNameGuide();
        CarScores carScores = new CarScores(InputView.getCarNames());

        OutputView.printRaceCountGuide();
        RaceCount raceCount = new RaceCount(InputView.getRaceCount());

        OutputView.printExecutionResult();
        for (int nowRaceTurn = 0; nowRaceTurn < raceCount.getValue(); nowRaceTurn++) {
            carScores = RaceService.playGame(carScores);
            System.out.println();
        }

        RaceService.findLastWinner(carScores);
    }
}
