package racingcar.app.server.model.dashboard;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

public class LapChart {
    private final String summary;

    private LapChart(final String summary) {
        this.summary = summary;
    }

    public static LapChart from(final String summary) {
        requireNonNull(summary, SHOULD_NOT_BE_NULL);
        return new LapChart(summary);
    }

    @Override
    public String toString() {
        return summary;
    }
}
