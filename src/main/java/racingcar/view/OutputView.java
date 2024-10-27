package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public static void printResultMessage() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public void printCarStatus(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(positions.get(i)));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnersList = String.join(", ",winners);
        System.out.println("최종 우승자 : " + winnersList);
    }
}
