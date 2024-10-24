package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputHandler {
    public static void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.printf("%s", winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
