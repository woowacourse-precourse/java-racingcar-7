package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private final StringBuilder winnerBuilder;

    public OutputView() {
        this.winnerBuilder = new StringBuilder(50); // 적절한 초기 크기로 설정
    }

    public void printWinners(List<String> winners) {
        winnerBuilder.setLength(0);
        winnerBuilder.append(WINNER_PREFIX);

        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                winnerBuilder.append(WINNER_DELIMITER);
            }
            winnerBuilder.append(winners.get(i));
        }
        System.out.println(winnerBuilder);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
