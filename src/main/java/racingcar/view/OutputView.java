package racingcar.view;

import java.util.List;
import racingcar.constant.OutputMessage;
import racingcar.dto.CarLocation;

public class OutputView {

    public void printRaceResultPrefix() {
        printNewLine();
        System.out.println(OutputMessage.RESULT_PREFIX);
    }

    public void printRaceProcess(List<CarLocation> raceResult) {
        raceResult.forEach(carLocation ->
                System.out.printf((OutputMessage.MOVEMENT_STATE_FORMAT) + "%n", carLocation.name(),
                        "-".repeat(carLocation.location()))
        );
        printNewLine();
    }

    public void printWinners(List<String> winners) {
        System.out.println(OutputMessage.WINNERS_ANNOUNCEMENT + String.join(OutputMessage.WINNER_DELIMITER, winners));
    }

    private void printNewLine() {
        System.out.println();
    }
}
