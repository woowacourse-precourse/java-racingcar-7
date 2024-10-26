package racingcar.view;

import static racingcar.view.Message.*;

import java.util.List;
import racingcar.controller.dto.RaceRoundResultDTO;
import racingcar.controller.dto.RaceRoundResultDTO.CarResult;

public class OutputView {

    public void printWinnerNames(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        WINNER_MESSAGE.printMessage(winners);
    }

    public void printResultTitle() {
        RESULT_TITLE_MESSAGE.printMessage();
    }

    public void printRoundResult(RaceRoundResultDTO raceResultDTO) {
        for (CarResult result : raceResultDTO.cars()) {
            String distance = "-".repeat(result.position());
            RESULT_CAR_MESSAGE.printMessage(result.name(), distance);
        }
        printEmptyLine();
    }

    public void requestCarNames() {
        REQUEST_NAME_MESSAGE.printMessage();
    }

    public void requestTotalTryRound() {
        REQUEST_TOTAL_TRY_COUNT_MESSAGE.printMessage();
    }
}
