package racingcar.global.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    static Validator validator;

    @BeforeAll
    static void setUp(){
        validator = Validator.getInstance();
    }
    @DisplayName("입력 값의 길이가 5를 넘으면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = "abcdef")
    void validateName(String name) {
        assertThatThrownBy(() -> validator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경기 횟수에 대해 문자, 공백으로 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource({"abc", "' "})
    void validateAndReturnCount(String count) {
        assertThatThrownBy(() -> validator.validateAndReturnCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경기 횟수에 대해 양수가 아닌 값 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource({"-1", "0"})
    void isPositiveNumber(Integer count) {
        assertThatThrownBy(() -> validator.isPositiveNumber(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}