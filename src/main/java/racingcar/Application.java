package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.RaceStadium;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceStadium raceStadium = new RaceStadium();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingController racingController = RacingController.of(raceStadium, inputView, outputView);
        racingController.startRacing();
    }
}
