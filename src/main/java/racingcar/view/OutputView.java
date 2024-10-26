package racingcar.view;

import static racingcar.view.Message.*;

import java.util.List;
import racingcar.controller.dto.RaceResultDTO;
import racingcar.controller.dto.RaceResultDTO.CarResult;

public class OutputView {

    public void printWinnerNames(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        WINNER_MESSAGE.printMessage(winners);
    }

    public void printRoundResult(RaceResultDTO raceResultDTO) {
        RESULT_TITLE_MESSAGE.printMessage();
        for (CarResult result : raceResultDTO.cars()) {
            String distance = "-".repeat(result.position());
            RESULT_CAR_MESSAGE.printMessage(result.name(), distance);
        }
        printEmptyLine();
    }

    public void requestCarNames() {
        REQUEST_NAME_MESSAGE.printMessage();
    }

    public void requestTotalRound() {
        REQUEST_TRY_COUNT_MESSAGE.printMessage();
    }
}
