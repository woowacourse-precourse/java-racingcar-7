package racingcar.app.server.model.dashboard;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.List;

public class LapChart {
    private final List<String> summaries;

    private LapChart(final List<String> summaries) {
        this.summaries = summaries;
    }

    public static LapChart from(final List<String> summaries) {
        requireNonNull(summaries, SHOULD_NOT_BE_NULL);
        return new LapChart(summaries);
    }

    @Override
    public String toString() {
        return String.join("\n", this.summaries);
    }
}
