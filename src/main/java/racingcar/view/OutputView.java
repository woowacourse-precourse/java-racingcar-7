package racingcar.view;

import static racingcar.view.ViewMessages.OUTPUT_MESSAGE;
import static racingcar.view.ViewMessages.WINNER_OUTPUT_MESSAGE;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.RoundResultDto;
import racingcar.dto.WinnerDto;

public class OutputView {

    public static void printRoundResults(List<RoundResultDto> roundResults) {
        System.out.println(OUTPUT_MESSAGE);
        roundResults.forEach(OutputView::printRoundResult);
    }

    private static void printRoundResult(RoundResultDto roundResult) {
        List<CarSnapShot> carSnapShots = roundResult.getCarSnapShots();
        carSnapShots.forEach(OutputView::printCarSnapShot);
    }

    private static void printCarSnapShot(CarSnapShot carSnapShot) {
        String carStatus = joinCarStatus(carSnapShot);
        System.out.println(carStatus);
    }

    private static String joinCarStatus(CarSnapShot carSnapShot) {
        return carSnapShot.getName()
                + " : "
                + "-".repeat(carSnapShot.getPosition())
                + "\n";
    }

    public static void printWinners(WinnerDto winners) {
        String winnerNames = joinWinners(winners);

        System.out.println(WINNER_OUTPUT_MESSAGE.getMessage() + winnerNames);
    }


    private static String joinWinners(WinnerDto winners) {
        List<String> winnerNames = winners.names();
        return String.join(", ", winnerNames);
    }


}
