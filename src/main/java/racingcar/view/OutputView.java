package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionRepresentation());
        }
        System.out.println(); // 줄 바꿈
    }

    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
