package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
