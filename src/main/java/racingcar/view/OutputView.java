package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printCarPosition(Car car) {
        String position = "-".repeat(car.getPosition());
        System.out.printf("%s : %s%n", car.getName(), position);
    }

    public void printRacingResult(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.printf("최종 우승자 : %s%n", String.join(", ", winnerNames));
    }
}
