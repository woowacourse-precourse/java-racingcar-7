package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {

    @DisplayName("주어진 값과 moveCount가 같은 경우 true를 반환한다.")
    @Test
    void isMoveCountEqualTo() {
        // given
        RacingCar racingCar = RacingCar.of("carName");
        int maxMoveCount = 3;
        for (int i = 0; i < maxMoveCount; i++) {
            racingCar.moveIfRandomNumberIsAbove(RacingCar.THRESHOLD);
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
            racingCar.moveIfRandomNumberIsAbove(RacingCar.THRESHOLD);
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