package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerResults {

    private final List<WinnerResult> winners;

    public WinnerResults(final List<String> winners) {
        this.winners = winners.stream()
                .map(carName -> new WinnerResult(carName))
                .collect(Collectors.toList());
    }

    String getResult() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getWinnerName());
            if (i != winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
