package racingcar.middleware.dto;

import racingcar.server.view.DashBoardView;

public record OutputDTO(
        String lapCharts,
        String winners
) {
    public static OutputDTO from(DashBoardView dashBoardView) {
        String lapCharts = dashBoardView.getLapCharts();
        String winners = dashBoardView.getWinners();
        return new OutputDTO(lapCharts, winners);
    }

    @Override
    public String lapCharts() {
        return lapCharts;
    }

    @Override
    public String winners() {
        return winners;
    }
}
