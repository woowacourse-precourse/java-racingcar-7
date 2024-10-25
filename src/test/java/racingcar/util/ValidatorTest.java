package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5글자를 넘으면 예외 발생")
    void carNameLengthTest() {
        // 5글자 이상의 이름을 포함한 리스트로 검증
        assertThatThrownBy(() -> Validator.carNameValidate(List.of("pobi", "polar", "ihavelongname")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복일 경우 예외 발생")
    void carNameDuplicateTest() {
        // 5글자 이상의 이름을 포함한 리스트로 검증
        assertThatThrownBy(() -> Validator.carNameValidate(List.of("pobi", "pobi", "ihavelongname")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외 발생")
    void carNameIsBlankTest(String input) {
        List<String> carNames = List.of(input);
        assertThatThrownBy(() -> Validator.carNameValidate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글자동차", ";;;"})
    @DisplayName("자동차 이름은 영어와 숫자만 허용")
    void carNameMatchPatternTest(String input) {
        List<String> carNames = List.of(input);
        assertThatThrownBy(() -> Validator.carNameValidate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("프린트 불가능한 문자를 포함한 자동차 이름일 경우 예외 발생")
    void carNameWithNonPrintableTest() {
        List<String> carNamesWithNonPrintable = List.of("pobi", "car1", "bear", "\u0007");

        assertThatThrownBy(() -> Validator.carNameValidate(carNamesWithNonPrintable))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("게임라운드 횟수 입력이 비어있는 경우 예외발생")
    void gameRoundIsEmptyTest(String input) {
        assertThatThrownBy(() -> Validator.gameRoundValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.1"})
    @DisplayName("게임라운드 횟수 입력이 양의 정수가 아닌경우")
    void gameRoundWithNegativeNumberTest(String input) {
        assertThatThrownBy(() -> Validator.gameRoundValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
