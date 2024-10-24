package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.entity.RacingChance;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingChanceFormatValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"마음껏달려봐", "111111111111111111111", "0", "\n"})
    @DisplayName("시도할 횟수 검증 예외 테스트")
    void chanceInputStringExceptionTest(String chanceNumberToValidate) {
        assertThatThrownBy(() -> RacingChance.getAfterValidateForm(chanceNumberToValidate)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "2025"})
    @DisplayName("시도할 횟수 검증 테스트")
    void chanceInputStringValidateTest(String chanceNumberToValidate) {
        assertDoesNotThrow(()
                -> RacingChance.getAfterValidateForm(chanceNumberToValidate));
    }
}
