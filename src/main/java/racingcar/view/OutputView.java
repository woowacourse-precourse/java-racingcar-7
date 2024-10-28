package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.CarSnapshot;

public class OutputView {

    public static void printRoundResults(List<CarSnapshot> carSnapshots) {
        for (CarSnapshot carSnapshot : carSnapshots) {
            System.out.println(carSnapshot.getName() + " : " + "-".repeat(carSnapshot.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printErrorMessage(String message) {
        System.out.println("에러: " + message);
    }

}