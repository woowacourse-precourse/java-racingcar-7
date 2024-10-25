package racingcar.view;

import static racingcar.common.Constant.BLANK;
import static racingcar.view.Instruction.FINAL_WINNER_PREFIX;
import static racingcar.view.Instruction.ROUND_RESULT_COMMENT;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.Round;

public class OutputView {
    public static final String DISTANCE_SIGN = "-";

    public void printRoundState(List<Round> roundList) {
        System.out.println(ROUND_RESULT_COMMENT);

        roundList.forEach(this::printCarState);
    }

    private void printCarState(Round round) {
        LinkedHashMap<String, Integer> state = round.getState();

        state.sequencedEntrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + DISTANCE_SIGN.repeat(entry.getValue()));
        });

        System.out.println();
    }

    public void printWinners(Round round) {
        String winners = String.join(BLANK, round.findAllLeadingCars());

        System.out.print(FINAL_WINNER_PREFIX + winners);
    }
}
