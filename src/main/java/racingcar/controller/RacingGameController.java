package racingcar.controller;

import racingcar.model.CarScores;
import racingcar.model.RaceCount;
import racingcar.service.RaceService;
import racingcar.view.InputView;

public class RacingGameController {
    public static void runRacingGame() {
        CarScores carScores = new CarScores(InputView.getCarNames());
        RaceCount raceCount = new RaceCount(InputView.getRaceCount());

        for(int nowRaceTurn = 0; nowRaceTurn < raceCount.getValue(); nowRaceTurn++) {
            carScores = RaceService.playGame(carScores);
        }

        // 최종 우승자 출력하기
    }
}
