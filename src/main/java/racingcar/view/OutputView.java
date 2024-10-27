package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.dto.GameResultDto;

public class OutputView {

    public static final String RESULT_START_MESSAGE = "실행 결과";
    public static final String DELIMITER = ", ";

    public static final String FINAL_WINNER_PREFIX = "최종 우승자 : ";


    public void showCurrentStatus(GameResultDto gameResultDto) {
        Map<String, Integer> gameDataMap = gameResultDto.getGameData();
        gameDataMap.forEach((carName, position) -> {
            System.out.println(carName + " : " + "-".repeat(position));
        });
        System.out.println();
    }

    public void showStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void showWinner(List<String> winners) {
        String winnerString = String.join(DELIMITER, winners);
        System.out.println(FINAL_WINNER_PREFIX + winnerString);
    }
}
