package racingcar;

import racingcar.commander.RandomMovementCommander;
import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private static final RacingController controller = new RacingController(new RandomMovementCommander());

    public static void main(String[] args) {
        Cars cars = toCars(InputView.readNames());
        int repeatCount = InputView.readRepeatCount();
        OutputView.renderWinner(runRace(repeatCount, cars));
    }

    private static Cars toCars(String names) {
        return controller.createCars(names);
    }

    private static Cars runRace(final int repeatCount, final Cars cars) {
        Cars result = cars;
        for (int i = 0; i < repeatCount; i++) {
            result = runOneRap(result);
            OutputView.renderCars(result);
        }
        return result;
    }

    private static Cars runOneRap(Cars cars) {
        return controller.rap(cars);
    }
}
