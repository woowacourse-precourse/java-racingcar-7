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

    public void offer(final LapChart lapChart) {
        lapCharts.add(lapChart);
    }

    public List<String> offerLapCharts() {
        return lapCharts
                .stream()
                .map(LapChart::toString)
                .toList();
    }
}