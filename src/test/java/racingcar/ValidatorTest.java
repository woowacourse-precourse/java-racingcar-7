package racingcar;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings =  {"2d", "yy", "#4", "한글","   ", " "})
    @DisplayName("시도 횟수 입력시 숫자가 아닌값 입력시 IllegalArgumentException() 예외처리")
    void validateNotNumber(String inputString) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->Validator.validateNotNumber(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 양수만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings =  {"", "0"})
    @DisplayName("시도 횟수 입력시 빈값 또는 0 입력시 IllegalArgumentException() 예외처리")
    void validateEmptyOrZeroString(String inputString) {
        Assertions.assertThatThrownBy(()->Validator.validateEmptyOrZeroTryCount(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 빈 값을 입력하셨습니다.");
    }

    @ParameterizedTest
    @MethodSource("unvalidatedNameSource")
    @DisplayName("이름 입력시 이름길이가 5자 초과시 IllegalArgumentException()예외처리")
    void validateNameLength(String over5wordname) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> Validator.validateNameLength(over5wordname))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5글자 이하의 이름만 입력할 수 있습니다.");
    }

    static Stream<Arguments> unvalidatedNameSource() {
        return Stream.of(
                Arguments.of("pobidd22"),
                Arguments.of("pobiii"),
                Arguments.of("over5word")
        );
    }

    @ParameterizedTest(name = "{index}번째 테스트. 이름:{0}은 5글자이상입니다. ")
    @MethodSource("unvalidatedFormatNameSource")
    @DisplayName("이름 입력시 이름포맷(영문, 숫자, '_') 이외 문자 입력시 IllegalArgumentException() 예외처리")
    void validateNameFormat(String unvalidatedFormatName) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> Validator.validateNameFormat(unvalidatedFormatName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 알파벳,숫자와 언더바(_)만 사용할 수 있습니다.");
    }

    static Stream<Arguments> unvalidatedFormatNameSource() {
        return Stream.of(
                Arguments.of("abc##%"),
                Arguments.of("한글한글")
                );
    }
}