package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.util.Validator.validateDuplicatedName;
import static racingcar.util.Validator.validateInputString;
import static racingcar.util.Validator.validateIntegerInput;
import static racingcar.util.Validator.validateNameLength;
import static racingcar.util.Validator.validateRacingCarCount;
import static racingcar.util.Validator.validatePositive;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTests {

    @Test
    @DisplayName("입력된 문자열에 사용된 쉼표에 문제가 없으면 쉼표를 기준으로 문자열을 분할")
    void splitIfDelimiterPositionValid() {
        String input = "alice,bob,john";
        List<String> expected = List.of("alice", "bob", "john");
        List<String> result = validateInputString(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열이 빈 문자열이거나 공백만 포함하는 문자열일 경우 예외 발생")
    @ValueSource(strings = {"", "      "})
    void throwExceptionIfInputIsBlank(String input) {
        assertThatThrownBy(() -> validateInputString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열의 쉼표가 잘못 사용되면 예외 발생")
    @ValueSource(strings = {",alice,bob,john", ",alice,bob,john", ",alice,bob,john", "alice,,bob,john"})
    void throwExceptionIfStartOrEndWithDelimiter(String input) {
        assertThatThrownBy(() -> validateInputString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 이름들 중 중복된 이름이 포함되어 있으면 예외 발생")
    void throwExceptionIfDuplicateNameContained() {
        List<String> input = List.of("alice", "bob", "alice", "john");
        assertThatThrownBy(() -> validateDuplicatedName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주에 참가하는 자동차가 2대 미만인 경우 예외 발생")
    void throwExceptionIfLessThanTwo() {
        List<String> name = List.of("alice");
        assertThatThrownBy(() -> validateRacingCarCount(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5글자를 초과하거나 빈 문자열일 경우 예외 발생")
    @ValueSource(strings = {"", "racer1"})
    void testIfNameLengthNotInRange(String name) {
        assertThatThrownBy(() -> validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 뽑기 횟수를 숫자형으로 변환할 수 없을 경우 IllegalArgumentException 발생")
    void throwExceptionIfTrialCountNotInteger() {
        String trialCountString = "a";
        assertThatThrownBy(() -> validateIntegerInput(trialCountString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 뽑기 횟수가 양이 아닌 정수이면 IllegalArgumentException 발생")
    @ValueSource(ints = {0, -1})
    public void throwExceptionIfTrialCountNotPositive(int trialCount) {
        assertThatThrownBy(() -> validatePositive(trialCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}