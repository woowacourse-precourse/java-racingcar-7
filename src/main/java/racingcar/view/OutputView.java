package racingcar.view;

import static racingcar.view.ViewMessages.NEW_LINE;
import static racingcar.view.ViewMessages.OUTPUT_MESSAGE;
import static racingcar.view.ViewMessages.WINNER_OUTPUT_MESSAGE;

import java.util.List;
import racingcar.domain.dto.CarSnapShot;
import racingcar.dto.RoundResultDto;
import racingcar.dto.WinnerDto;
import racingcar.util.FormatUtil;

public class OutputView {

    public static void printRoundResults(List<RoundResultDto> roundResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OUTPUT_MESSAGE.getMessage())
                .append(NEW_LINE.getMessage());

        roundResults.forEach(roundResult -> stringBuilder.append(getRoundResultString(roundResult)));

        System.out.print(stringBuilder);
    }

    private static String getRoundResultString(RoundResultDto roundResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<CarSnapShot> carSnapShots = roundResult.getCarSnapShots();

        carSnapShots.forEach(
                carSnapShot -> stringBuilder
                        .append(FormatUtil.joinCarStatus(carSnapShot))
                        .append(NEW_LINE.getMessage()));

        stringBuilder.append(NEW_LINE.getMessage());

        return stringBuilder.toString();
    }

    public static void printWinners(WinnerDto winners) {
        String winnerNames = FormatUtil.joinWinners(winners);
        System.out.println(WINNER_OUTPUT_MESSAGE.getMessage() + winnerNames);
    }

}
