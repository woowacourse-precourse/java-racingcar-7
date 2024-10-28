package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


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

    @Test
    void CarNamesLengthTest() {
        assertThatThrownBy(() -> {
            Application.carNamesLength(List.of("pobbii"));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 최대 5자입니다.");

        List<String> validCarNames = List.of("i", "wonii", "jun");

        assertThatNoException().isThrownBy(() -> {
            Application.carNamesLength(validCarNames);
        });
    }
}