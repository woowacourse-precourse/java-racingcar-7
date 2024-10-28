package console;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConsoleUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", "aaaaaa", "abcdef"})
    @DisplayName("자동차 이름이 5글자를 초과하면 IllegalArgumentException 발생하는지 확인")
    void ifCarNameOver5tThrowsException(String carName) {
        assertThatThrownBy(() -> ConsoleUtil.generateExceptionIfNameAbove5(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1.1", "e", "asdf", " ", "", "11:11", "-=(&$@", "[10]"})
    @DisplayName("자연수가 입력되지않았을때 IllegalArgumentException 발생하는지 확인")
    void ifNotNaturalNumberThrowsException(String inputNumber) {
        assertThatThrownBy(() -> ConsoleUtil.checkCountException(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483648", "100000000000000000"})
    @DisplayName("int 내부 범위가 아닐 때 IllegalArgumentException 발생하는지 확인")
    void ifNotIntRangeThrowsException(String inputNumber) {
        assertThatThrownBy(() -> ConsoleUtil.checkCountException(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"  ", "   "})
    @DisplayName("빈 값 혹은 null일때 IllegalArgumentException 발생여부 확인")
    void ifNullOrBlankThrowsException2(String input) {
        assertThatThrownBy(() -> ConsoleUtil.checkIsNotNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa, bb", "aa,,cc"})
    @DisplayName("자동차 이름이 문자와 쉼표만으로 이루지지않았을때 IllegalArgumentException 발생여부 확인")
    void ifInvalidCarNameThrowsException(String carNames) {
        assertThatThrownBy(() -> ConsoleUtil.checkCarNameException(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }


}