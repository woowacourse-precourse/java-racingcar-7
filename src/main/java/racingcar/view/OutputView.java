package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void executionResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void currentStatusMessage(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void finalWinnerMessage(List<Car> winners) {
        List<String> carNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        String message = "최종 우승자 : " + String.join(", ", carNames);
        System.out.println(message);
    }


}
