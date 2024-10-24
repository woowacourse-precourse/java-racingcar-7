package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        Round round = new Round(0);
        assertThat(round.isEnd()).isEqualTo(true);
    }
}
