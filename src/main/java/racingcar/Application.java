package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.RaceTrack;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceTrack raceTrack = new RaceTrack();

        RaceController gameController = new RaceController(inputView, outputView, raceTrack);
        gameController.run();
    }
}
