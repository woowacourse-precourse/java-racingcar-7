package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundCountTest {
    @Test
    @DisplayName("RoundCount 객체를 생성할 수 있다.")
    void createRoundCount() {
        // given
        int roundCount = 5;
        // when
        RoundCount round = new RoundCount(roundCount);
        // then
        Assertions.assertThat(round).isNotNull();
    }
}