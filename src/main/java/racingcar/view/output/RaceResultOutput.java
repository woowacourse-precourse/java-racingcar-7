package racingcar.view.output;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResultOutput {
    public static String printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return "최종 우승자 : " + winnerNames;
    }
}
