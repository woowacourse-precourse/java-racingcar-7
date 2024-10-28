package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private ArrayList<Car> cars;
    private int tryNumber;

    public RacingGame(ArrayList<Car> cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public List<String> race() {
        int nowTry = 0;
        while (tryNumber != nowTry) {
            for (Car car : cars) {
                car.checkForward();
                System.out.println(car.getName() + " : " + car.getRacingCount());
            }
            System.out.println();
            nowTry++;
        }
        int maxCount = getMaxCount();
        return getWinner(maxCount);

    }


    private List<String> getWinner(int maxCount) {
        List<String> winners = cars.stream()
                .filter(car -> car.getRacingCount().length() == maxCount)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxCount() {
        int maxCount = cars.stream()
                .mapToInt(car -> car.getRacingCount().length())
                .max()
                .orElse(0);
        return maxCount;
    }
}
