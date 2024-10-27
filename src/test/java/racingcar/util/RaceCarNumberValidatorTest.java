package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.validator.RacingCarNumberValidator;

class RaceCarNumberValidatorTest {

    private RacingCarNumberValidator racingCarNumberValidator;

    @BeforeEach
    void setUp() {
        racingCarNumberValidator = new RacingCarNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "10.", " ", ","})
    @DisplayName("숫자 형식 또는 빈문자열이 아니므로 예외가 발생한다.")
    void validateFormatTest(final String value) throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(() -> racingCarNumberValidator.validateFormat(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 10000})
    @DisplayName("숫자가 최대 범위를 초과하여 예외가 발생한다.")
    void validateRangeTest(final int value) {
        //given
        final int maxValue = 1;
        //when
        //then
        assertThatThrownBy(() -> racingCarNumberValidator.validateRange(value, maxValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}