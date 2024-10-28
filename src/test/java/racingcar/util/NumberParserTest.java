package racingcar.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    @DisplayName("양의 정수 문자열을 정수로 변환한다")
    void 양의_정수_변환() {
        assertThat(NumberParser.parsePositiveInteger("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 문자열을 입력하면 예외를 발생시킨다")
    void 음수_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parsePositiveInteger("-1"));
    }

    @Test
    @DisplayName("0을 입력하면 예외를 발생시킨다")
    void 영_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parsePositiveInteger("0"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자열 입력 시 예외를 발생시킨다")
    void 숫자가_아닌_문자열_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parsePositiveInteger("abc"));
    }

    @Test
    @DisplayName("공백이 포함되는 경우 예외를 발생시킨다")
    void 공백_포함_문자열_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parsePositiveInteger(" 12"));
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parsePositiveInteger(" 1 "));
    }

}