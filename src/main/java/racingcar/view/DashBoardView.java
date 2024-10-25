package racingcar.view;

import static racingcar.common.message.OutputMessage.NO_WINNER;

import racingcar.model.dashboard.DashBoard;

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
        if (winnerExistOn(offeredLWinners)) {
            return new DashBoardView(offeredLapCharts, offeredLWinners);
        }
        return new DashBoardView(offeredLapCharts, NO_WINNER);
    }

    private static boolean winnerExistOn(String offeredLWinners) {
        return !offeredLWinners.isBlank();
    }

    public String getLapCharts() {
        return lapCharts;
    }

    public String getWinners() {
        return winners;
    }
}
