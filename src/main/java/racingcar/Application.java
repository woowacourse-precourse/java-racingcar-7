package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Cars cars = new Cars();

        RaceController raceController = new RaceController(inputView, outputView, cars);
        raceController.run();
    }
}
