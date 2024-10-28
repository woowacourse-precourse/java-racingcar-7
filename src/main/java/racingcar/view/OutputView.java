package racingcar.view;

import java.util.List;

public class OutputView {

    public static void displayStartMessage() {
        System.out.println("실행 결과");
    }
    public static void displayProgress(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    // 우승자 출력
    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
