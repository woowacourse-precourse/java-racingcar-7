package racingcar.view;

import static racingcar.view.Instruction.FINAL_WINNER_PREFIX;
import static racingcar.view.Instruction.ROUND_RESULT_COMMENT;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.Round;

public class OutputView {
    public static final String DISTANCE_SIGN = "-";
    public static final String WINNER_JOIN_DELIMITER = ", ";

    public void printRoundState(List<Round> roundList) {
        System.out.println(ROUND_RESULT_COMMENT);

        roundList.forEach(this::printCarState);
    }

    private void printCarState(Round round) {
        LinkedHashMap<String, Integer> state = round.getState();

        state.sequencedEntrySet().forEach(entry -> {
            String carName = entry.getKey();
            String distance = DISTANCE_SIGN.repeat(entry.getValue());

            System.out.println(carName + " : " + distance);
        });

        System.out.println();
    }

    public void printWinners(Round round) {
        String winners = String.join(WINNER_JOIN_DELIMITER, round.findAllLeadingCars());

        System.out.print(FINAL_WINNER_PREFIX + winners);
    }
}
