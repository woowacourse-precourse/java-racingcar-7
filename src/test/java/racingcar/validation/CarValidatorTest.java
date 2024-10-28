package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesValidatorTest {
    CarNamesValidator validator = new CarNamesValidator();

    @ParameterizedTest
    @ValueSource(strings = {"myCars", "badExample", "ab12cde3", "abcdefg", ""})
    @DisplayName("자동차 이름의 길이가 유효한 길이인지 검증")
    void 자동차_이름의_길이를_검증(String carName) {
        assertThatThrownBy(() -> validator.validateCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc de", "goo d", "to do", "a  b"})
    @DisplayName("자동차 이름에 공백이 포함되었는지 검증")
    void 자동차_이름의_공백_유무를_검증(String carName) {
        assertThatThrownBy(() -> validator.validateCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"c1.c2", "abc|d", "car.d", "a/b23"})
    @DisplayName("자동차 이름을 다른 구분자로 구분했는지 검증")
    void 자동차_이름에_다른_구분자가_있는지_검증(String carName) {
        assertThatThrownBy(() -> validator.validateCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}