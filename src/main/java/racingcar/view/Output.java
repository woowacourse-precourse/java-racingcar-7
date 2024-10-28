package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Output {
    public static void printResultString() {
        System.out.println("실행 결과");
    }

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatus());
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
