package racingcar;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Player> players) {
        System.out.println("차수별 실행 결과");
        for (Player player : players) {
            System.out.println(player.getName() + " : " + player.getPositionIndicator());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
