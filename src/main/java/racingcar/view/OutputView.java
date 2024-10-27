package racingcar.view;

import java.util.Map;
import racingcar.model.dto.FinalResultDto;
import racingcar.model.dto.RoundResultDto;

public class OutputView {
    private static final String POSITION_SIGN = "-";

    public void printResultMessage() {
        System.out.println(ViewMessage.RESULT_MESSAGE.getMessage());
    }

    public void printRoundResult(RoundResultDto result) {
        System.out.println();
        Map<String, String> resultMap = result.roundResult();
        resultMap.forEach(
                (name, position) -> System.out.println(
                        name + " : " + POSITION_SIGN.repeat(Integer.parseInt(position))
                )
        );
    }

    public void printWinners(FinalResultDto winners) {
        System.out.println();
        System.out.print(ViewMessage.WINNERS_MESSAGE.getMessage() + winners.toString());
    }
}
