package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.validator.RacingCarStringValidator;

class RacingCarStringValidatorTest {

    private RacingCarStringValidator racingCarStringValidator;

    @BeforeEach
    void setUp() {
        racingCarStringValidator = new RacingCarStringValidator();
    }

    @Test
    @DisplayName("문자열이 빈문자열이므로 예외가 발생한다.")
    void validateFormatTest() throws Exception {
        //given
        final String value = "";

        //when
        //then
        assertThatThrownBy(() -> racingCarStringValidator.validateFormat(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열의 길이가 최대 범위를 초과하여 예외가 발생한다.")
    void validateLengthTest() throws Exception {
        //given
        final String value = "붕붕붕 아주 작은 자동차";
        final int maxValue = 5;

        //when
        //then
        assertThatThrownBy(() -> racingCarStringValidator.validateLength(value, maxValue))
                .isInstanceOf(IllegalArgumentException.class);

    }

}