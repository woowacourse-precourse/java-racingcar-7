package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class Output {

    public static final String DISTANCE_UNIT = "-";

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + DISTANCE_UNIT.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnersName);
    }
}
