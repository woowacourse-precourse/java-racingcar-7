package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printError(String message) {
        System.out.println("입력 오류: " + message);
    }
}
