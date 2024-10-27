package racingcar.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    public void raceStart() {
        OutputView.printCarNamesRequest();
        String carNames = InputView.inputCarNames();
        OutputView.printAttemptCountRequest();
        int attemptCount = InputView.inputAttemptCount();

        List<Car> cars = makeCars(carNames);


        OutputView.printResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            attemptRound(cars);
        }

        OutputView.printWinner(findWinnerNames(cars));
    }

    private void attemptRound(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
            System.out.print(car.toStringCarPosition(car));
        }
        System.out.println();
    }

    private List<String> findWinnerNames(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int findMaxDistance(List<Car> cars) {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
