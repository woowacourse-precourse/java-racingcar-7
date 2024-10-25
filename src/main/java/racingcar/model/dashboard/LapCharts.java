package racingcar.model.dashboard;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.exception.ShouldNotBeNullException;

public class LapCharts {
    private final List<LapChart> lapCharts;

    private LapCharts() {
        this.lapCharts = new ArrayList<>();
    }

    public static LapCharts initiate() {
        return new LapCharts();
    }

    public void offer(final String lapChart) {
        validateIsNull(lapChart);
        lapCharts.add(LapChart.from(lapChart));
    }

    private void validateIsNull(final String source) {
        if (isNull(source)) {
            throw new ShouldNotBeNullException();
        }
    }

    @Override
    public String toString() {
        List<String> summaries = lapCharts.stream().map(LapChart::toString).toList();
        return String.join("\n\n", summaries);
    }
}
