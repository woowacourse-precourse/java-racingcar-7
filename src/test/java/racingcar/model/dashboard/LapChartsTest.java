package racingcar.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LapChartsTest {

    @Test
    @DisplayName("lap chart 확인")
    void checkLapCharts() {
        // given
        LapCharts lapCharts = LapCharts.initiate();
        lapCharts.offer("a : \nb : --\nc : ---");
        lapCharts.offer("a : -\nb : --\nc : ----");
        lapCharts.offer("a : --\nb : ---\nc : -----");

        // when
        String actual = lapCharts.toString();

        // then
        String expected = """
                a :\s
                b : --
                c : ---

                a : -
                b : --
                c : ----

                a : --
                b : ---
                c : -----""";
        assertThat(actual).isEqualTo(expected);
    }
}
