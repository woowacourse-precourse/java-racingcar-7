package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}