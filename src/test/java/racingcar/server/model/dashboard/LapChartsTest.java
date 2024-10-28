package racingcar.server.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.model.dashboard.LapChart;
import racingcar.app.server.model.dashboard.LapCharts;

public class LapChartsTest {

    @Test
    @DisplayName("lap chart 확인")
    void checkLapCharts() {
        // given
        LapCharts lapCharts = LapCharts.initiate();

        List<String> firstLapChart = List.of("a : ", "b : --", "c : ---");
        List<String> secondLapChart = List.of("a : -", "b : --", "c : ----");
        List<String> thirdLapChart = List.of("a : --", "b : ---", "c : -----");

        lapCharts.offer(LapChart.from(firstLapChart));
        lapCharts.offer(LapChart.from(secondLapChart));
        lapCharts.offer(LapChart.from(thirdLapChart));

        // when
        List<String> actual = lapCharts.offerLapCharts();

        // then
        String expectedFirstLapChart = "a : \nb : --\nc : ---";
        String expectedSecondLapChart = "a : -\nb : --\nc : ----";
        String expectedThirdLapChart = "a : --\nb : ---\nc : -----";
        assertThat(actual).contains(
                expectedFirstLapChart,
                expectedSecondLapChart,
                expectedThirdLapChart
        );
    }
}
