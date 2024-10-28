package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        CarRaceController controller = new CarRaceController();

        String inputCar = InputView.setInputCar();
        String inputGameMatches = InputView.setInputGameMatches();
        controller.race(inputCar, inputGameMatches);

    }
}
