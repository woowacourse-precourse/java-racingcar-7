package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void run() {
        OutputView.requestCarName();
        List<Car> raceParticipants = InputView.getCarNames();
        OutputView.requestRound();
        int round = InputView.getRound();


    }

}
