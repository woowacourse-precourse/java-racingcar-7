package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingHistory {

    private final List<String> history = new ArrayList<>();

    private RacingHistory() {
    }

    public static RacingHistory of() {
        return new RacingHistory();
    }

    public void append(List<String> status) {
        history.add(String.join("\n", new ArrayList<>(status)));
    }

    @Override
    public String toString() {
        return String.join("\n\n", history);
    }
}
