package racingcar.model.dashboard;

public class LapChart {
    private final String summary;

    private LapChart(final String summary) {
        this.summary = summary;
    }

    public static LapChart from(final String summary) {
        return new LapChart(summary);
    }

    @Override
    public String toString() {
        return summary;
    }
}
