package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RoundTest {
    @Test
    void 라운드_생성() {
        Round round = new Round(5);
        assertThat(round).isNotNull();
    }

    @Test
    void 라운드_감소() {
        Round round = new Round(5);
        assertThat(round.nextRound()).isEqualTo(new Round(4));
    }

    @Test
    void 라운드_종료() {
        Round round = new Round(1).nextRound();
        assertThat(round.isEnd()).isEqualTo(true);
    }

    @Test
    void 라운드_최소값_검증() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
