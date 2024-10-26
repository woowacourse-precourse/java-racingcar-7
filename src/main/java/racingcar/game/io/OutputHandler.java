package racingcar.game.io;

import java.util.List;
import racingcar.game.model.RaceSnapshot;
import racingcar.game.model.Winners;

public class OutputHandler {
    private static final String WINNER_DELIMITER = ", ";
    private static final String PROGRESS_SIGN = "-";

    public void showCarInputMessage() {
        System.out.println(OutputMessage.CAR_INPUT_NAVIGATE.getTemplate());
    }

    public void showAttemptCountInputMessage() {
        System.out.println(OutputMessage.ATTEMPT_COUNT_INPUT_NAVIGATE.getTemplate());
    }

    public void showCurrentRaceSnapshot(List<RaceSnapshot> snapShots) {
        snapShots.stream()
                .map(this::formatSnapshot)
                .forEach(System.out::println);
    }

    public void showWinners(Winners winners) {
        String formattedWinners = formatWinners(winners.getNames());
        System.out.printf(OutputMessage.WINNER.getTemplate() + "\n", formattedWinners);
    }

    private String formatSnapshot(RaceSnapshot snapShot) {
        String carName = snapShot.carName();
        int moveCount = snapShot.moveCount();
        String progressSigns = PROGRESS_SIGN.repeat(moveCount);

        return String.format(OutputMessage.CAR_MOVE_PROGRESS.getTemplate(), carName, progressSigns);
    }

    private String formatWinners(List<String> names) {
        return String.join(WINNER_DELIMITER, names);
    }
}