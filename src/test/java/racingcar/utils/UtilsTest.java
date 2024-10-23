package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    @DisplayName("자동차 이름 검증 테스트 - 올바른 입력은 예외를 던지지 않는다.")
    void givenValidInput_whenValidateNames_thenCorrectResult() {
        String input1 = "aa,bb,cc1";
        Assertions.assertDoesNotThrow(() -> Utils.validateNames(input1));
        String input2 = "12345,aaaaa";
        Assertions.assertDoesNotThrow(() -> Utils.validateNames(input2));
    }

    @Test
    @DisplayName("자동차 이름 검증 테스트 - 0글자 혹은 5글자 초과인 경우 예외를 던진다.")
    void givenInvalidLength_whenValidateNames_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames("aa,123456"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames(""));
    }

    @Test
    @DisplayName("자동차 이름 검증 테스트 - ,로 시작하거나 ,로 끝나면 예외를 던진다.")
    void givenStartingOrEndingComma_whenValidateNames_thenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames(",aa,bb"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames("aa,bcb,d,"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames(",aa,bbb,aac"));
    }

    @Test
    @DisplayName("자동차 이름 검증 테스트 - 연속된 컴마가 있는 경우 예외를 던진다.")
    void givenContainingConsecutiveCommas_whenValidateNames_thenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames(",,,"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateNames("a,,b,,,c"));
    }


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