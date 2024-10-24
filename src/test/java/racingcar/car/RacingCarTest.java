package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("moveCount만큼 -문자가 반복된 문자열을 반환한다")
    @Test
    void getProgress() {
        // given
        RacingCar racingCar = RacingCar.of("carName");
        int maxMoveCount = 3;
        for (int i = 0; i < maxMoveCount; i++) {
            racingCar.increaseMoveCount();
        }

        // when
        String progress = racingCar.getProgress();

        // then
        assertThat(progress).isEqualTo("---");
    }

    @DisplayName("랜덤 숫자에 따라 이동한다.")
    @CsvSource({"3, 0", "4, 1"})
    @ParameterizedTest
    void moveIfRandomNumberIsAbove(int number, int moveCount) {
        // given
        RacingCar racingCar = RacingCar.of("car");

        // when
        racingCar.moveIfRandomNumberIsAbove(number);

        // then
        assertThat(racingCar.getMoveCount()).isEqualTo(moveCount);
    }


}