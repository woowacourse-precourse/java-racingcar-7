package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarInfo;

public class OutputView {

    private final String WINNER_DELIMITER = ", ";
    private final String EMPTY_STRING = "";
    private final String LINE_SEPARATOR = "\n";
    private final String ROUND_SEPARATOR = "\n\n";
    private final String CAR_INFO_SEPARATOR = " : ";
    private final String POSITION_SYMBOL = "-";
    private final int SINGLE_WINNER_THRESHOLD = 1;

    public void printRoundResult(List<List<CarInfo>> roundResults) {
        System.out.println("\n실행 결과\n" + formatRoundResults(roundResults));
    }

    public void printWinnerList(List<String> winners) {
        System.out.println("\n최종 우승자 : " + formatWinners(winners));
    }

    public String formatWinners(List<String> winners) {
        if (winners.size() > SINGLE_WINNER_THRESHOLD) {
            return String.join(WINNER_DELIMITER, winners);
        } else {
            return String.join(EMPTY_STRING, winners);
        }
    }

    public String formatRoundResults(List<List<CarInfo>> allRoundCarInfos) {
        return allRoundCarInfos.stream()
                .map(carInfos -> carInfos.stream()
                        .map(carInfo -> carInfo.getName() + CAR_INFO_SEPARATOR + POSITION_SYMBOL.repeat(
                                carInfo.getCurrentPosition()))
                        .collect(Collectors.joining(LINE_SEPARATOR))
                )
                .collect(Collectors.joining(ROUND_SEPARATOR));
    }

}
