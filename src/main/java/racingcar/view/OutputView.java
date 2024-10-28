package racingcar.view;

import racingcar.constant.CommonMessage;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    public void printCarNamePrompt() {
        System.out.println(CommonMessage.CAR_NAME_PROMPT.getMessage());
    }

    public void printAttemptPrompt() {
        System.out.println(CommonMessage.ATTEMPT_PROMPT.getMessage());
    }

    public void printRaceResultStart() {
        System.out.println();
        System.out.println(CommonMessage.RACE_RESULT_START.getMessage());
    }

    public void printRaceRound(List<String> carNames, List<Integer> positions) {
        IntStream.range(0, carNames.size()).forEach(i ->
                System.out.println(carNames.get(i) + " : " + "-".repeat(positions.get(i)))
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(CommonMessage.WINNERS_MESSAGE.getMessage() + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.out.println(CommonMessage.ERROR_MESSAGE_PREFIX.getMessage() + message);
    }
}