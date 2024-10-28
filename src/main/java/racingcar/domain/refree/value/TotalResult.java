package racingcar.domain.refree.value;

import java.util.List;
import java.util.stream.Collectors;

public class TotalResult {

    private final List<SingleResult> values;
    private final WinnerNames winnerNames;

    public TotalResult(List<SingleResult> values, WinnerNames winnerNames) {
        this.values = values;
        this.winnerNames = winnerNames;
    }

    public String resultToString() {
        return values.stream()
                .map(SingleResult::toString)
                .collect(Collectors.joining("\n"));
    }

    public String winnerNamesToString() {
        return winnerNames.toString();
    }
}
