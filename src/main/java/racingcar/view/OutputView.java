package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    public void printCarPosition(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void printWinners(ArrayList<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void printExecutionResult() {
        System.out.println("\n실행 결과");
    }
}
