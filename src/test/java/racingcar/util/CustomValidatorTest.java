package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomValidatorTest {

    @DisplayName("문자열의 길이가 5 이하인지 확인하는 테스트")
    @Test
    void validateLengthTrue() {
        //given
        String str = "12345";

        //when
        boolean result = CustomValidator.validateLength(str);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("문자열의 길이가 5 초과인지 확인하는 테스트")
    @Test
    void validateLengthFalse() {
        //given
        String str = "123456";

        //when
        boolean result = CustomValidator.validateLength(str);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("숫자인지 확인하는 테스트")
    @Test
    void validateNumberTrue() {
        //given
        String str = "123";

        //when
        boolean result = CustomValidator.validateNumber(str);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("숫자가 아닌지 확인하는 테스트")
    @Test
    void validateNumberFalse() {
        //given
        String str = "123as";

        //when
        boolean result = CustomValidator.validateNumber(str);

        //then
        assertThat(result).isFalse();
    }
}