package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("increaseMoveCount 메서드를 호출하면 moveCount가 1 증가한다")
    @Test
    void increaseMoveCount() {
        // given
        RacingCar racingCar = RacingCar.of("carName");

        // when
        racingCar.increaseMoveCount();

        // then
        assertThat(racingCar.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("주어진 값과 moveCount가 같은 경우 true를 반환한다.")
    @Test
    void isMoveCountEqualTo() {
        // given
        RacingCar racingCar = RacingCar.of("carName");
        int maxMoveCount = 3;
        for (int i = 0; i < maxMoveCount; i++) {
            racingCar.increaseMoveCount();
        }

        // when
        boolean result = racingCar.isMoveCountEqualTo(maxMoveCount);

        // then
        assertThat(result).isTrue();
    }
}