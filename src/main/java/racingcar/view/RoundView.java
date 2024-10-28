package racingcar.view;

import static racingcar.message.RoundMessage.ROUND_START_MESSAGE;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.model.RacingRecord;

public class RoundView implements View {

    private final RacingGame racingGame;
    private boolean isStart = true;

    public RoundView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void printRound() {
        List<RacingRecord> records = racingGame.getRecords();
        StringBuilder printResult = new StringBuilder();

        for (RacingRecord record : records) {
            String carName = record.getCarName();
            int moveDistance = record.getMoveDistance();

            printResult.append(carName).append(" : ").append("-".repeat(moveDistance)).append("\n");
        }
        System.out.print(printResult + "\n");
    }

    public void printStartMessage() {
        System.out.print(ROUND_START_MESSAGE.getMessage() + "\n");
    }

    @Override
    public String printView() {
        if (isStart) {
            printStartMessage();
            isStart = false;
        }
        printRound();
        return null;
    }
}
