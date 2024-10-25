package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovementValueTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 9})
    @DisplayName("0에서 9 사이의 정수 값이 정상적으로 MovementValue에 저장된다")
    void 정상적인_값이_MovementValue에_저장된다(int validValue) {
        MovementValue movementValue = MovementValue.from(validValue);

        assertThat(movementValue.value())
                .isEqualTo(validValue);
    }
}