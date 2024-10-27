package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberUtil;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String[] names, int tryCount) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void start() {
        for(int i = 0; i < tryCount; i++) {
            for(Car car : cars) {
                if (RandomNumberUtil.getRandomNumber() >= 4) {
                    car.move();
                }
                car.printStatus();
            }
            System.out.println();
        }
    }

    public String getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }

    public List<Car> getCars() {
        return cars;
    }
}
