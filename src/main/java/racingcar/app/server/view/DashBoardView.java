package racingcar.app.server.view;

import racingcar.app.server.model.dashboard.DashBoard;

public class DashBoardView {

    private final String lapCharts;
    private final String winners;

    private DashBoardView(final String lapCharts, final String winners) {
        this.lapCharts = lapCharts;
        this.winners = winners;
    }

    public static DashBoardView from(DashBoard dashBoard) {
        String offeredLapCharts = dashBoard.offerLapCharts();
        String offeredLWinners = dashBoard.offerLWinners();
        return new DashBoardView(offeredLapCharts, offeredLWinners);
    }

    public String getLapCharts() {
        return lapCharts;
    }

    public String getWinners() {
        return winners;
    }
}
