package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarNamesTest {

    @Test
    void splitCarNames() {
        assertThat(Application.getCarNames("pobi,woni,jun.wonjun'jun won")).isEqualTo(List.of("pobi","woni","jun.wonjun'jun won"));
    }

    @Test
    void CarNamesException() {
        assertThatThrownBy(() -> {
            Application.getCarNames("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차가 없습니다.");

        assertThatThrownBy(() -> {
            Application.getCarNames(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차가 없습니다.");
    }
}