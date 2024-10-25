package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.RandomDigitGenerator;
import racingcar.util.RandomGenerator;

class PositionTest {

    @Test
    @DisplayName("position을 성공적으로 생성한다.")
    void successfullyCreatePosition() {
        //given
        RandomGenerator randomGenerator = new RandomDigitGenerator();

        //when then
        assertDoesNotThrow(() -> new Position(randomGenerator));
    }

    @Nested
    @DisplayName("move 메서드를 실행시킬 때")
    class whenMove {

        @ParameterizedTest
        @CsvSource({"0", "1", "2", "3"})
        @DisplayName("랜덤 숫자가 4 미만인 경우 움직이지 않는다.")
        void doesNotMovePositionWhenLessThanStandard(int randomNumber) {
            //given
            Position position = new Position(() -> randomNumber);
            int expected = 0;

            //when
            position.move();
            int actual = position.getPosition();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({"4", "5", "6", "7", "8", "9"})
        @DisplayName("랜덤 숫자가 4 이상인 경우 한칸 움직인다.")
        void movePositionWhenEqualOrMoreThanStandard(int randomNumber) {
            //given
            Position position = new Position(() -> randomNumber);
            int expected = 1;

            //when
            position.move();
            int actual = position.getPosition();

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}