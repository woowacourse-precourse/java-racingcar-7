package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.InvalidInputException;
import racingcar.common.utils.StringSplitter;

class StringSplitterTest {

    @Test
    @DisplayName("문자열이 null인 경우 예외가 발생해야 한다.")
    void nullStringExceptionTest() {
        // given, when, then
        assertThatThrownBy(() -> StringSplitter.splitByComma(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InvalidInputException.forInvalidInput().getMessage());
    }

    @Test
    @DisplayName("빈 문자열인 경우 예외가 발생해야 한다.")
    void emptyStringExceptionTest() {
        // given, when, then
        assertThatThrownBy(() -> StringSplitter.splitByComma(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InvalidInputException.forInvalidInput().getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a , b, c", " a ,b, c"})
    @DisplayName("쉼표로 이름을 구분할 수 있어야 한다.")
    void splitByCommaTest(String value) {
        // when
        List<String> values = StringSplitter.splitByComma(value);

        // then
        assertThat(values).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {",a,b,c", "a,b,c,", ",a,b,c,"})
    @DisplayName("문자열의 앞이나 뒤에 쉼표가 있다면 예외가 발생해야 한다.")
    void invalidCommaExistsExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> StringSplitter.splitByComma(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InvalidInputException.forInvalidInput().getMessage());
    }
}