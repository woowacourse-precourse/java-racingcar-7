package racingcar.game.io;

import java.util.List;
import racingcar.game.model.RaceSnapshot;
import racingcar.game.model.Winners;

public class OutputHandler {
    private static final String CAR_NAMES_NAVIGATE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_NAVIGATE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_TEMPLATE = "최종 우승자 : %s";
    private static final String CAR_MOVE_PROGRESS_TEMPLATE = "%s : %s";
    private static final String WINNER_DELIMITER = ", ";
    private static final String PROGRESS_SIGN = "-";

    public void showCarNamesNavigateMessage() {
        System.out.println(CAR_NAMES_NAVIGATE_MESSAGE);
    }

    public void showAttemptCountNavigateMessage() {
        System.out.println(ATTEMPT_COUNT_NAVIGATE_MESSAGE);
    }

    public void showCurrentAccumulation(List<RaceSnapshot> snapShots) {
        snapShots.stream()
                .map(this::formatSnapshot)
                .forEach(System.out::println);
    }

    public void showWinners(Winners winners) {
        String formattedWinners = formatWinners(winners.getNames());
        System.out.printf(WINNER_TEMPLATE + "\n", formattedWinners);
    }

    private String formatSnapshot(RaceSnapshot snapShot) {
        String carName = snapShot.carName();
        int moveCount = snapShot.moveCount();
        String progressSigns = PROGRESS_SIGN.repeat(moveCount);

        return String.format(CAR_MOVE_PROGRESS_TEMPLATE, carName, progressSigns);
    }

    private String formatWinners(List<String> names) {
        return String.join(WINNER_DELIMITER, names);
    }
}