package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRaceController carRaceController = new CarRaceController(
                new CarRaceService(),
                new InputView(),
                new OutputView());

        carRaceController.run();
    }
}
