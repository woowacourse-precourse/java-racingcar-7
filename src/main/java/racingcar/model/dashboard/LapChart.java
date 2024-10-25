package racingcar.model.dashboard;

import static java.util.Objects.isNull;

import racingcar.common.exception.ShouldNotBeNullException;

public class LapChart {
    private final String summary;

    private LapChart(final String summary) {
        this.summary = summary;
    }

    public static LapChart from(final String summary) {
        validateIsNull(summary);
        return new LapChart(summary);
    }

    private static void validateIsNull(String summary) {
        if (isNull(summary)) {
            throw new ShouldNotBeNullException();
        }
    }

    @Override
    public String toString() {
        return summary;
    }
}
