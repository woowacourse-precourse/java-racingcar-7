package racingcar.function;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.OutputView;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<String> carNames, int attempts) {
        this.cars = initializeCars(carNames);
        this.attempts = attempts;
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputView.printCurrentState(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
