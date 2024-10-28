package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printInitialMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<String> cars) {
        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
