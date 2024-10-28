package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceService raceService = new RaceService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceController controller = new RaceController(raceService, inputView, outputView);

        controller.run();
    }
}