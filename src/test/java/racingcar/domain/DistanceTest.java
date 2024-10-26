package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {
    @DisplayName("거리 증가가 가능하다.")
    @Test
    void 거리증가() {
        Distance distance = new Distance(0);
        Distance increaseDistance = distance.increaseDistance();
        assertThat(increaseDistance.getDistanceValue()).isEqualTo(1);
    }

    @DisplayName("최대값 구하기")
    @Test
    void 최대값() {
        Distance distance = new Distance(5);
        assertAll(
                () -> assertThat(distance.max(6)).isEqualTo(6),
                () -> assertThat(distance.max(4)).isEqualTo(5)
        );
    }

    @DisplayName("같은 값 구하기")
    @Test
    void 같은값() {
        Distance distance = new Distance(5);
        assertAll(
                () -> assertThat(distance.isSameDistance(5)).isTrue(),
                () -> assertThat(distance.isSameDistance(6)).isFalse()
        );
    }
}
