package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidatorTest {

    private final CarNameValidator validator = new CarNameValidator();

    @Test
    @DisplayName("자동차 이름이 5자를 넘어가면 실패한다")
    void validate_ThrowsExceptionIfNameIsTooLong() {
        // Given
        List<String> carNames = Arrays.asList("short", "longfailname");

        // When & Then
        assertThatThrownBy(() -> validator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 이하면 성공한다")
    void validate_NamesAreLessThanFiveCharacters() {
        // Given
        List<String> carNames = Arrays.asList("1", "22", "333", "4444");

        // When & Then
        assertThatCode(() -> validator.validate(carNames))
                .doesNotThrowAnyException();

    }
}
