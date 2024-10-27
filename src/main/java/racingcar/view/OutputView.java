package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void displayCurrentPositions(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }

    public static void announceWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}