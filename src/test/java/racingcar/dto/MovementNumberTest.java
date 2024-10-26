package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovementNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 9})
    @DisplayName("0에서 9 사이의 정수 값이 정상적으로 MovementNumber 저장된다")
    void 정상적인_값이_MovementNumber에_저장된다(int validNumber) {
        MovementNumber movementNumber = MovementNumber.from(validNumber);

        assertThat(movementNumber.value())
                .isEqualTo(validNumber);
    }
}