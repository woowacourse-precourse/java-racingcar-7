package racingcar.Controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    public void raceStart() {
        OutputView.printCarNamesRequest();
        String carNames = InputView.inputCarNames();
        OutputView.printAttemptCountRequest();
        int attemptCount = InputView.inputAttemptCount();

        Cars cars = makeCars(carNames);

        OutputView.printResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            attemptRound(cars);
        }

        OutputView.printWinner(cars.findWinners());
    }

    private void attemptRound(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveForward();
            System.out.print(car.toStringCarPosition(car));
        }
        System.out.println();
    }

    private Cars makeCars(String carNames) {
        return new Cars(Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}
