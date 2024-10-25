package racingcar;

import java.util.List;

public class OutputHandler {
    public static void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 :");
        System.out.println(String.join(", ", winners));
    }
}
