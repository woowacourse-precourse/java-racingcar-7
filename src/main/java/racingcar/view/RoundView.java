package racingcar.view;

import static racingcar.message.RoundMessage.ROUND_START_MESSAGE;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.model.RacingRecord;

public class RoundView {
    private final RacingGame racingGame;

    public RoundView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printRound() {
        List<RacingRecord> records = racingGame.getRecords();
        String printResult = "";

        for (RacingRecord record : records) {
            String carName = record.getCarName();
            int moveDistance = record.getMoveDistance();

            printResult += carName + " : " + "-".repeat(moveDistance) + "\n";
        }
        System.out.print(printResult + "\n");
    }

    public void printStartMessage() {
        System.out.println(ROUND_START_MESSAGE.getMessage());
    }
}
