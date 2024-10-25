package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String SHOW_RESULT = "\n실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void showResultMessage() {
        System.out.println(SHOW_RESULT);
    }

    public void printCarPositions(List<String> carNames, List<Integer> carPositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(WINNER + result);
    }
}