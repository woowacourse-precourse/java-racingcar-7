package racingcar.constants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {
    @Test
    void notAllowedFirstLastBlankTest() {
        // given
        String expected = "문장 맨 앞, 맨 뒤에는 공백이 포함 되지 않아야 합니다.";

        // when
        String real = ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK;

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void tryCountMustBeNumericTest() {
        // given
        String expected = "시도할 횟수는 정수를 입력 해야 합니다.";

        // when
        String real = ErrorMessage.TRY_COUNT_MUST_BE_NUMERIC;

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void notAllowedUnderMinimumTryCountTest() {
        // given
        String expected = "시도할 횟수는 1 이상이어야 합니다.";

        // when
        String real = ErrorMessage.NOT_ALLOWED_UNDER_MINIMUM_TRY_COUNT;

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void notAllowedCarNameLengthTest() {
        // given
        String expected = "자동차 이름은 1자 이상, 5 자 이하여야 합니다.";

        // when
        String real = ErrorMessage.NOT_ALLOWED_CAR_NAME_LENGTH;

        // then
        assertThat(real).isEqualTo(expected);
    }
}