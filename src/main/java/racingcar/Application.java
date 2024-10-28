package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.RacePolicy;
import racingcar.model.RaceTrack;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacePolicy racePolicy = new RacePolicy();
        RaceTrack raceTrack = new RaceTrack(racePolicy);

        RaceController raceController = new RaceController(inputView, outputView, raceTrack);
        raceController.run();
    }
}
