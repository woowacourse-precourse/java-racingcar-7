package racingcar.app.middleware.dto;

import java.util.List;
import racingcar.app.server.view.DashBoardView;

public record OutputDTO(
        List<String> lapCharts,
        List<String> winners
) {
    public static OutputDTO from(DashBoardView dashBoardView) {
        List<String> lapCharts = dashBoardView.getLapCharts();
        List<String> winners = dashBoardView.getWinners();
        return new OutputDTO(lapCharts, winners);
    }

    @Override
    public List<String> lapCharts() {
        return lapCharts;
    }

    @Override
    public List<String> winners() {
        return winners;
    }
}
