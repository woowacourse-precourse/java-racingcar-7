package racingcar.view;

import java.util.List;
import racingcar.enums.IOMessages;

public class OutputView {
    private static final char PRE_ELEMS = '[';
    private static final int FOR_NEXT_IDX = 1;
    private static final char POST_ELEMS = ']';

    public void roundResultHeader() {
        System.out.println(IOMessages.ROUND_RESULT_HEADER.getMsg());
    }

    public void printRoundResult(String allRoundStatus) {
        System.out.print(allRoundStatus);
    }

    public void printFinalResult(List<String> result) {
        System.out.print(IOMessages.PRE_RESULT.getMsg());
        String finalWinners = result.toString();
        System.out.print(removeBracket(finalWinners));
    }

    private String removeBracket(String finalWinners) {
        return finalWinners.substring(finalWinners.indexOf(PRE_ELEMS) + FOR_NEXT_IDX, finalWinners.indexOf(POST_ELEMS));
    }
}
