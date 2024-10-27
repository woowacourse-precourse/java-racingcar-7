package racingcar.app.server.model.dashboard;

import java.util.ArrayList;
import java.util.List;

public class LapCharts {

    private final List<LapChart> lapCharts;

    private LapCharts() {
        this.lapCharts = new ArrayList<>();
    }

    public static LapCharts initiate() {
        return new LapCharts();
    }

    public void offer(final String lapChart) {
        lapCharts.add(LapChart.from(lapChart));
    }

    public List<String> offerLapCharts() {
        return lapCharts
                .stream()
                .map(LapChart::toString)
                .toList();
    }
}
