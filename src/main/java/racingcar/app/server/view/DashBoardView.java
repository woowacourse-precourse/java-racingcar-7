package racingcar.app.server.view;

import java.util.List;
import racingcar.app.server.model.dashboard.DashBoard;

public class DashBoardView {

    private final List<String> lapCharts;
    private final List<String> winners;

    private DashBoardView(final List<String> lapCharts, final List<String> winners) {
        this.lapCharts = lapCharts;
        this.winners = winners;
    }

    public static DashBoardView from(final DashBoard dashBoard) {
        List<String> offeredLapCharts = dashBoard.offerAllLapCharts();
        List<String> offeredLWinners = dashBoard.offerLWinners();
        return new DashBoardView(offeredLapCharts, offeredLWinners);
    }

    public List<String> getLapCharts() {
        return lapCharts;
    }

    public List<String> getWinners() {
        return winners;
    }
}
