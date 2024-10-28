package racingcar.view;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> car) {
        for (Car c : car) {
            System.out.println(c.getName() + " : " + "-".repeat(c.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}
