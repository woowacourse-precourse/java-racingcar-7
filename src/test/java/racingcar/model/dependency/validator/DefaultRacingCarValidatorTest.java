package racingcar.model.dependency.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("DefaultRacingCarValidator 테스트")
public class DefaultRacingCarValidatorTest {

    private final DefaultRacingCarValidator defaultRacingCarValidator = new DefaultRacingCarValidator();

    @Test
    @DisplayName("validateName() : 이름이_null인_경우_예외가_발생한다")
    void 이름이_null인_경우_예외가_발생한다() {

        // given
        String name = null;

        // when, then
        assertThatThrownBy(() -> defaultRacingCarValidator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateName() : 이름이_최대_길이를_초과하는_경우_예외가_발생한다")
    void 이름이_최대_길이를_초과하는_경우_예외가_발생한다() {

        // given
        String name = "a".repeat(defaultRacingCarValidator.MAX_NAME_LENGTH + 1);

        // when, then
        assertThatThrownBy(() -> defaultRacingCarValidator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "이름: {0}")
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("validateName() : 이름이_공백인_경우_예외가_발생한다")
    void 이름이_공백인_경우_예외가_발생한다(String name) {

        // when, then
        assertThatThrownBy(() -> defaultRacingCarValidator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
