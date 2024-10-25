package racingcar.view;

import java.util.stream.Collectors;
import racingcar.dto.CarRecord;
import racingcar.dto.RacingResult;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalRoundResult;
import racingcar.dto.WinnerResult;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과\n";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String CAR_POSITION_SYMBOL = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void printResult(RacingResult racingResult) {
        printExecuteResult(racingResult.totalRoundResult());
        printWinner(racingResult.winnerResult());
    }

    private static void printExecuteResult(TotalRoundResult totalRoundResult) {
        String result = EXECUTION_RESULT_MESSAGE + totalRoundResult.roundResults().stream()
                .map(OutputView::formatRoundResult)
                .collect(Collectors.joining("\n")) + "\n";
        System.out.print(result);
    }

    private static String formatRoundResult(RoundResult roundResult) {
        return roundResult.carRecords().stream()
                .map(OutputView::formatCarRecord)
                .collect(Collectors.joining("\n")) + "\n";
    }

    private static String formatCarRecord(CarRecord carRecord) {
        return carRecord.name() + NAME_POSITION_SEPARATOR + CAR_POSITION_SYMBOL.repeat(carRecord.position());
    }

    private static void printWinner(WinnerResult winnerResult) {
        System.out.print(WINNER_MESSAGE + String.join(WINNER_DELIMITER, winnerResult.winnerNames()));
    }
}
