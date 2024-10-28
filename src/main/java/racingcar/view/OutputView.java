package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printExecutionText() {
        System.out.println();
        System.out.println("실행 결과");
    }


    public static void printCarsMoveStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }


    public static void printFinalWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
