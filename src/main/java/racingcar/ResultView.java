package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printCurrentResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println(); // 각 라운드 사이에 빈 줄 추가
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}