package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private final RacePrinter printer = new RacePrinter();
    private List<Car> cars;

    public void start(List<String> carNames, int raceTimes) {
        cars = initCars(carNames);
        printer.printStartMessage();
        runRace(raceTimes);
        printer.printWinner(checkWinner());
    }

    private void runRace(int raceTimes) {
        for (int i = 0; i < raceTimes; i++) {
            moveAllCars();
            printer.printRace(cars);
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            if (randomNumber() >= 4) {
                car.move();
            }
        }
    }

    private List<Car> checkWinner() {
        List<Car> winners = new ArrayList<>();
        int maxValue = findMaxValue();
        for (Car car : cars) {
            if (car.getMoveCount() == maxValue) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int findMaxValue() {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getMoveCount());
        }
        return maxValue;
    }

    private List<Car> initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
