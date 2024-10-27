package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public static void game() {
        List<String> carNames = InputView.getCars();
        Validator.validateCarNames(carNames);

        int round = Validator.validateRound(InputView.getRounds());
        Cars cars = createCars(carNames);

        OutputView.printResultText();
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            OutputView.printResult(cars);
        }

        OutputView.printWinner(cars.getWinners());
    }

    public static Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}
