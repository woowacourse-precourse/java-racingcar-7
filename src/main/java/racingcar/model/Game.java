package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String[] carNames;
    private final List<Car> cars = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public Game(String[] carNames) {
        this.carNames = carNames;
    }

    public List<String> getWinners() {
        findWinners();
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void makeCars() {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void start() {
        makeCars();
    }

    public void playTurn() {
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
