package racingcar.view;

import racingcar.model.dto.FinalResultDto;
import racingcar.model.dto.RoundResultDto;

public class OutputView {
    private static final String POSITION_SIGN = "-";

    public void printResultMessage() {
        System.out.print("\n" + ViewMessage.RESULT_MESSAGE.getMessage());
    }

    public void printRoundResult(RoundResultDto result) {
        System.out.println();
        result.roundResult().forEach(
                individual -> System.out.println(
                        individual.name() + " : " + POSITION_SIGN.repeat(individual.position())
                )
        );
    }

    public void printWinners(FinalResultDto winners) {
        System.out.println();
        System.out.print(ViewMessage.WINNERS_MESSAGE.getMessage() + winners.toString());
    }
}
