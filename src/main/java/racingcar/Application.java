package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String raceCarNames = InputView.inputRaceCarNames();
        String moveCount = InputView.inputMoveCount();

        RaceController raceController = new RaceController(new RaceService());
        System.out.println(raceController.doRace(raceCarNames,moveCount));
    }
}
