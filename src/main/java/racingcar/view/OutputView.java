package racingcar.view;


import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getCurrentPosition()));
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}