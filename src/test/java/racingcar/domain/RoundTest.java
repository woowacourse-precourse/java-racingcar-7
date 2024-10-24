package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void hasNext() {
        Round round1 = new Round(1);
        Round round2 = new Round(2);

        assertThat(round1.hasNext()).isFalse();
        assertThat(round2.hasNext()).isTrue();
    }

    @Test
    void next() {
        Round round = new Round(3);

        assertThat(round.getCurrent()).isEqualTo(1);
        round.next();
        assertThat(round.getCurrent()).isEqualTo(2);

        round.next();
        assertThat(round.getCurrent()).isEqualTo(3);
    }
}