package racingcar;

import racingcar.model.RaceManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(
                new InputView(),
                new OutputView()
        );
        raceManager.run();
    }
}
