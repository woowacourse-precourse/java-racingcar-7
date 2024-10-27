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

    public void race() {
        int nowTry = 0;
        while (tryNumber != nowTry) {
            for (Car car : cars) {
                car.checkForward();
                System.out.println(car.getName() + " : " + car.getRacingCount());
            }
            System.out.println();
            nowTry++;
        }
        printWinners();
    }

    private void printWinners() {
        // 최대 카운트 값을 찾음
        int maxCount = cars.stream()
                .mapToInt(car -> car.getRacingCount().length())
                .max()
                .orElse(0);

        // 최대 카운트를 가진 우승자들을 찾음
        List<String> winners = cars.stream()
                .filter(car -> car.getRacingCount().length() == maxCount)
                .map(Car::getName)
                .collect(Collectors.toList());

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
