package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printRaceStatus(Race race) {
        for (Car car : race.getCars()) {
            System.out.println(car);
        }
    }

    public void announceWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
