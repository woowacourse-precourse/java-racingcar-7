package racingcar;

import java.util.List;

public class OutputManager {

    static void displayWinner(List<String> winnerList) {
        String winner = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winner);
    }
}
