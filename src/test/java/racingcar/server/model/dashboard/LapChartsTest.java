package racingcar.server.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.model.dashboard.LapCharts;

public class LapChartsTest {

    @Test
    @DisplayName("lap chart 확인")
    void checkLapCharts() {
        // given
        LapCharts lapCharts = LapCharts.initiate();

        String firstLapChart = "a : \nb : --\nc : ---";
        String secondLapChart = "a : -\nb : --\nc : ----";
        String thirdLapChart = "a : --\nb : ---\nc : -----";

        lapCharts.offer(firstLapChart);
        lapCharts.offer(secondLapChart);
        lapCharts.offer(thirdLapChart);

        // when
        List<String> actual = lapCharts.offerLapCharts();

        // then
        assertThat(actual).contains(firstLapChart, secondLapChart, thirdLapChart);
    }
}
