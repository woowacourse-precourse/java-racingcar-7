package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printRaceResult(List<String> players, List<Integer> progress) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i) + " : " + "-".repeat(progress.get(i)));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
