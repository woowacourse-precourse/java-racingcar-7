package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.view.InputView.*;

class InputTest {
    @Test
    @DisplayName("쉼표를 기준으로 문자열 분할")
    void splitDelimiterPositionValid() {
        String input = "pobi,woni,wj";
        List<String> expected = List.of("pobi","woni","wj");
        List<String> result = validateCarNames(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 혹은 공백만 포함하는 문자열인 경우")
    @ValueSource(strings = {"","    "})
    void exceptionIfInputIsBlank(String input) {
        assertThatThrownBy(() -> checkEmptyInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 0글자인 문자열이 포함된 경우")
    void exceptionIfCarNameEmpty() {
        List<String> input = List.of("pobi","","wj");
        assertThatThrownBy(() -> checkCarNameException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 6글자 이상인 경우")
    void exceptionIfCarNameLengthExceed() {
        String input = "wonjun";
        assertThatThrownBy(() -> checkCarNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름에 공백이 포함된 경우")
    @ValueSource(strings = {"po bi"," wj "})
    void exceptionIfCarNameWhitespace(String input) {
        assertThatThrownBy(() -> checkCarNameNoWhitespace(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 중복된 경우")
    void exceptionIfCarNameNotUnique() {
        Set<String> uniqueName = Set.of("pobi","wj");
        String input = "wj";
        assertThatThrownBy(() -> checkCarNameUnique(input,uniqueName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 중복된 경우")
    void exceptionIfCountCarNameOne() {
        List<String> input = List.of("wj");
        assertThatThrownBy(() -> checkCountCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수가 숫자가 아닌 경우")
    void exceptionIfCountNotInteger() {
        String countString = "a";
        assertThatThrownBy(() -> validateNumberFormat(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수가 실수인 경우")
    void exceptionIfCountFloat() {
        String countString = "3.5";
        assertThatThrownBy(() -> intEqualsFloatCount(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수에 공백이 포함된 경우")
    void exceptionIfCountWhiteSpace() {
        String countString = " 1";
        assertThatThrownBy(() -> validateWhitespace(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("횟수가 음수 혹은 0인 경우")
    @ValueSource(ints = {0, -1})
    public void exceptionIfCountNotPositive(int count) {
        assertThatThrownBy(() -> checkInRangeTryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("횟수가 비정상적으로 많은 경우")
    @ValueSource(ints = {2000000000, 99999999})
    public void exceptionIfCountMaxCount(int count) {
        assertThatThrownBy(() -> checkInRangeTryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
