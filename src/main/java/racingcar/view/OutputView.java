package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_SEPARATOR = ", ";

    public void printWinnerMessage(List<String> winnerList) {
        String winnerListMessage = getWinnerListMessage(winnerList);
        System.out.println(WINNER_MESSAGE + winnerListMessage);
    }

    private String getWinnerListMessage(List<String> winnerList) {
        return String.join(WINNER_SEPARATOR, winnerList);
    }
}
