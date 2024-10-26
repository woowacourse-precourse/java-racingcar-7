package racingcar.game.io;

import java.util.List;
import racingcar.game.model.Car;
import racingcar.game.model.RacingCars;
import racingcar.game.model.Winners;

public class OutputHandler {
    private static final String CAR_NAMES_NAVIGATE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_NAVIGATE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_TEMPLATE = "최종 우승자 : %s";
    private static final String CAR_PROGRESS_BAR_TEMPLATE = "%s : %s";
    private static final String WINNER_DELIMITER = ", ";

    public void showCarNamesNavigateMessage() {
        System.out.println(CAR_NAMES_NAVIGATE_MESSAGE);
    }

    public void showAttemptCountNavigateMessage() {
        System.out.println(ATTEMPT_COUNT_NAVIGATE_MESSAGE);
    }

    public void showCurrentAccumulation(RacingCars racingCars) {
        for (Car car : racingCars.getParticipatingCars()) {
            String carName = car.getName();
            int moveCount = car.getMoveCount();
            String movedProgressBar = "-".repeat(moveCount);
            String formattedEachResult = String.format(CAR_PROGRESS_BAR_TEMPLATE, carName, movedProgressBar);
            System.out.println(formattedEachResult);
        }
        System.out.println();
    }

    public void showWinners(Winners winners) {
        String formattedWinners = formatWinners(winners.getNames());
        System.out.printf(WINNER_TEMPLATE + "\n", formattedWinners);
    }

    private String formatWinners(List<String> names) {
        return String.join(WINNER_DELIMITER, names);
    }
}