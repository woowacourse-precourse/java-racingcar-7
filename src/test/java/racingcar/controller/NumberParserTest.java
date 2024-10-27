package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.INPUT_TOO_LONG;
import static racingcar.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static racingcar.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberParserTest {

    private NumberParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    void 숫자_문자열을_정수로_변환한다() {
        // given
        String input = "123";

        // when
        int result = numberParser.parse(input);

        // then
        assertThat(result).isEqualTo(123);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열_입력시_예외를_던진다(String input) {
        // when & then
        assertThatThrownBy(() -> numberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_INPUT.message());
    }

    @Test
    void null_입력시_예외를_던진다() {
        // when & then
        assertThatThrownBy(() -> numberParser.parse(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_INPUT.message());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "9999999999"})
    void 길이가_10_이상인_입력시_예외를_던져_오버플로우를_방지한다(String input) {
        // when & then
        assertThatThrownBy(() -> numberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TOO_LONG.message());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a", "1.2", "가나다"})
    void 숫자가_아닌_문자열_입력시_예외를_던진다(String input) {
        // when & then
        assertThatThrownBy(() -> numberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_FORMAT.message());
    }

    @Test
    void 앞뒤_공백이_있는_숫자는_정상_변환된다() {
        // given
        String input = " 123 ";

        // when
        int result = numberParser.parse(input);

        // then
        assertThat(result).isEqualTo(123);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void 다양한_길이의_유효한_숫자를_변환한다(String input) {
        // when
        int result = numberParser.parse(input);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 최대_허용_자릿수_숫자를_변환한다() {
        // given
        String input = "999999999"; // 9자리

        // when
        int result = numberParser.parse(input);

        // then
        assertThat(result).isEqualTo(999999999);
    }
}
