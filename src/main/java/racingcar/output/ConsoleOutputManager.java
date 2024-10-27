package racingcar.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class ConsoleOutputManager implements OutputManager {

    @Override
    public void displayPosition(List<Car> cars) {
        for (Car car : cars) {
            String positionIndicator = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + positionIndicator);
        }
    }

    @Override
    public void displayWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }
}
