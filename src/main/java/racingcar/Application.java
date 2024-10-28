package racingcar;

import java.util.List;
import racingcar.controller.RaceController;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();
        Cars cars = new Cars(carNames);

        RaceController raceController = new RaceController(cars);
        raceController.startRace(rounds);
    }
}