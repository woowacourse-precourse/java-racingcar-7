package racingcar;

import java.util.List;

public class OutputManager {

    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printWinner(List<String> winners) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(", ", winners));
    }
}
