package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }

    }

    public void displayWinners(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst().getName());
        } else {
            String winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            System.out.println("최종 우승자 : " + winnerNames);
        }

    }
}
