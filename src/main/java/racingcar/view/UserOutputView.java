package racingcar.view;

import java.util.List;

public class UserOutputView {

    public static void outputStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void outputResult(String name, int distance) {
        String stringBuilder = name + " : " + "-".repeat(distance);
        System.out.println(stringBuilder);
    }

    public static void outputWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");

        String winner = String.join(", ", winners);

        System.out.println(winner);
    }
}
