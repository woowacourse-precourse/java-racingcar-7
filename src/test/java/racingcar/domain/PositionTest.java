package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position을 성공적으로 생성한다.")
    void successfullyCreatePosition() {
        //when then
        assertDoesNotThrow(Position::new);
    }
}