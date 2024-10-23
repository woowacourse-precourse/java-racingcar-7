package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {


    @Test
    @DisplayName("숫자 검증 및 파싱 테스트 - 올바른 입력엔 올바른 결과가 나온다")
    void givenValidInput_whenParseNumber_thenCorrectResult() {
        String input = "1";
        int expected = 1;
        int result = Utils.parseNumber(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("숫자 검증 및 파싱 테스트 - 숫자가 아닌 입력은 예외를 던진다.")
    void givenNonNumberInput_whenParseNumber_thenIllegalArgumentException() {
        String input = "메롱";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.parseNumber(input));
    }

    @Test
    @DisplayName("숫자 검증 및 파싱 테스트 - 0 이하의 수는 예외를 던진다.")
    void givenUnderZero_whenParseNumber_thenIllegalArgumentException() {
        String input = "-1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.parseNumber(input));
    }
}