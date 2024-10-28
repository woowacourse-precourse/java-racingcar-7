package racingcar.view;

import static racingcar.view.ViewMessages.OUTPUT_MESSAGE;
import static racingcar.view.ViewMessages.WINNER_OUTPUT_MESSAGE;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.RoundResultDto;
import racingcar.dto.WinnerDto;
import racingcar.util.FormatUtil;

public class OutputView {

    public static void printRoundResults(List<RoundResultDto> roundResults) {
        System.out.println(OUTPUT_MESSAGE.getMessage());
        roundResults.forEach(OutputView::printRoundResult);
    }

    private static void printRoundResult(RoundResultDto roundResult) {
        List<CarSnapShot> carSnapShots = roundResult.getCarSnapShots();
        carSnapShots.forEach(OutputView::printCarSnapShot);
        System.out.println();
    }

    private static void printCarSnapShot(CarSnapShot carSnapShot) {
        String carStatus = FormatUtil.joinCarStatus(carSnapShot);
        System.out.println(carStatus);
    }

    public static void printWinners(WinnerDto winners) {
        String winnerNames = FormatUtil.joinWinners(winners);
        System.out.println(WINNER_OUTPUT_MESSAGE.getMessage() + winnerNames);
    }

}
