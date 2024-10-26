package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.exception.ErrorMessage.INVALID_NAME_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.NAME_DUPLICATE;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("이름이 1글자 미만, 5글자를 초과하는 입력이 하나라도 있으면 예외가 발생해야한다.")
    void nameLengthValidate(List<String> names) {
        assertThatThrownBy(() -> Validator.namesValidate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    static Stream<List<String>> nameLengthValidate() {
        return Stream.of(
                List.of("aaaaaa", "bbbb", "cccc"),
                List.of("a", "bbbbbbb", "ccccc"),
                List.of("aaaaa", "bbbbbb", "cccccc"),
                List.of("", "b", "c"),
                List.of("a", "", "")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("자동차 이름이 2개 미만으로 들어온 경우 예외가 발생해야한다.")
    void nameCountValidate(List<String> names) {
        assertThatThrownBy(() -> Validator.namesValidate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_COUNT.getMessage());
    }

    static Stream<List<String>> nameCountValidate() {
        return Stream.of(
                List.of("aaaaa"),
                List.of()
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("자동차 이름에 중복이 있을 경우 예외가 발생해야한다.")
    void duplicateNameValidate(List<String> names) {
        assertThatThrownBy(() -> Validator.namesValidate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_DUPLICATE.getMessage());
    }

    static Stream<List<String>> duplicateNameValidate() {
        return Stream.of(
                List.of("aaa", "aaa"),
                List.of("aaa", "bbbb", "cc", "aaa"),
                List.of("aaaa", "aaaa", "aaaa")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("정상 이름 입력 값에 대해서는 예외가 발생하지 않는다.")
    void successValidate(List<String> names) {
        assertThatNoException().isThrownBy(() -> Validator.namesValidate(names));
    }

    static Stream<List<String>> successValidate() {
        return Stream.of(
                List.of("aaa", "bbb"),
                List.of("aaa", "bbbb", "cc"),
                List.of("aaaa", "cccc", "asds")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-123"})
    @DisplayName("레이싱 횟수는 1 이상이여한다. 1 미만인 경우 예외가 발생한다.")
    void countRangeValidate(String count) {
        assertThatThrownBy(() -> Validator.countValidate(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COUNT_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "1,2", "as2"})
    @DisplayName("횟수 입력은 숫자만 가능하다. 숫자가 아닌 입력이 오면 예외가 발생한다.")
    void numberFormatValidate(String count) {
        assertThatThrownBy(() -> Validator.countValidate(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER.getMessage());
    }
}