package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    void 자동차경주_총라운드_1회_미만_에러() {
        Assertions.assertThatThrownBy(() -> new Race(0, new Cars("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1회 이상 진행되어야 합니다.");

        Assertions.assertThatThrownBy(() -> new Race(-1, new Cars("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1회 이상 진행되어야 합니다.");
    }

    @Test
    void 자동차경주_총라운드_1회_이상_점검() {
        Assertions.assertThat(new Race(1, new Cars("pobi")).getTotalRaceTurn())
                .isEqualTo(1);

        Assertions.assertThat(new Race(30, new Cars("pobi")).getTotalRaceTurn())
                .isEqualTo(30);
    }

    @Test
    void 우승자_발표() {
        Assertions.assertThat(new Race(2, new Cars("pobi")).getWinner())
                .contains("pobi");
    }
}
