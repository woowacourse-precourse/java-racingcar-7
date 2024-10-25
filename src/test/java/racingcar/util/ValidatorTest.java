package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
