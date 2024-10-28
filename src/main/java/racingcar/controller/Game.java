package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String[] carNames;
    private final int count;
    private final List<Car> cars = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public Game(String[] carNames, int count) {
        this.carNames = carNames;
        this.count = count;
    }

    public List<String> run() {
        makeCars();
        start();
        return winners;
    }

    private void makeCars() {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void start() {
        int currentCnt = 0;
        while (currentCnt < count) {
            playTurn();
            OutputView.printProgressRacing(cars);
            currentCnt++;
        }
        findWinners();
    }

    private void playTurn() {
        for (Car car : cars) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                car.move();
            } else {
                car.stop();
            }
        }
    }

    private void findWinners() {
        int maxDistance = findMaxDistance();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }
}
