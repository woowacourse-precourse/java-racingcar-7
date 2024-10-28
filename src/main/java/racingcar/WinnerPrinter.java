package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerPrinter {
    public static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
