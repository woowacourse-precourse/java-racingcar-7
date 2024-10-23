package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private static final String WINNERS_PREFIX = "최종 우승자 : ";
    private static final String WINNERS_DELIMITER = ", ";

    private final List<Car> cars;

    public RaceGame(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        String[] names = RaceUtil.parseCarNames(carNames);
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void playRound() {
        for (Car car : cars) {
            if (RaceUtil.canMove()) {
                car.moveForward();
            }
        }
    }

    private void printCurrentStatus() {
        for (Car car : cars) {
            System.out.println(car.getCurrentPosition());
        }
        System.out.println();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinners() {
        List<String> winners = getWinners();
        System.out.println(WINNERS_PREFIX + String.join(WINNERS_DELIMITER, winners));
    }
}
