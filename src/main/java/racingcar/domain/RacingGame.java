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
        // 최대 카운트 값을 찾음
        int maxCount = getMaxCount();
        // 최대 카운트를 가진 우승자들을 찾음
        List<String> winners = getWinner(maxCount);
        printWinners(winners);
    }

    private void printWinners(List<String> winners) {

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
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
