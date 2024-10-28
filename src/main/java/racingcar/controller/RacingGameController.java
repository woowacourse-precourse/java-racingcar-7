package racingcar.controller;

import racingcar.model.CarScores;
import racingcar.model.RaceCount;
import racingcar.service.RaceWinnerService;
import racingcar.service.RoundRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static int INIT_TURN_TO_ZERO = 0;

    public static void run() {
        OutputView.printCarNameGuide();
        CarScores carScores = new CarScores(InputView.getCarNames());
        OutputView.printRaceCountGuide();
        RaceCount raceCount = new RaceCount(InputView.getRaceCount());

        carScores = raceForRaceCountTimes(carScores, raceCount);

        RaceWinnerService.findLastWinner(carScores);
    }

    private static CarScores raceForRaceCountTimes(CarScores carScores, RaceCount raceCount) {
        OutputView.printExecutionResult();
        for (int nowRaceTurn = INIT_TURN_TO_ZERO; nowRaceTurn < raceCount.getValue(); nowRaceTurn++) {
            carScores = RoundRaceService.playGame(carScores);
            System.out.println();
        }
        return carScores;
    }
}
