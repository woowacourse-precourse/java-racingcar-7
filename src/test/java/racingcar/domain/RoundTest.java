package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void Round_진행_테스트() {
        Round round = new Round(3);

        assertThat(round.getCurrent()).isEqualTo(0);
        round.next();
        assertThat(round.getCurrent()).isEqualTo(1);

        round.next();
        assertThat(round.getCurrent()).isEqualTo(2);
        round.next();
        assertThat(round.getCurrent()).isEqualTo(3);
        assertThat(round.hasNext()).isFalse();
    }

    @Test
    void 최종_라운드는_1_이하를_가질_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Round(0);
        });
    }
}