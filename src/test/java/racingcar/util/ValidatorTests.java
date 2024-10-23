package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.util.Validator.validateInputString;
import static racingcar.util.Validator.validateNameCount;
import static racingcar.util.Validator.validateNameLength;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTests {

    @Test
    @DisplayName("입력된 문자열에서 쉼표가 문자열의 중간에 있으면 쉼표를 기준으로 문자열을 분할")
    void splitIfDelimiterPositionValid() {
        String input = "alice,bob,charlie";
        List<String> expected = List.of("alice", "bob", "charlie");
        List<String> result = validateInputString(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("입력한 문자열이 빈 문자열이거나 공백만 포함하는 문자열일 경우 예외 발생")
    void exceptionIfInputIsBlank() {
        assertThatThrownBy(() -> validateInputString("      "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateInputString(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자열이 쉼표로 시작하거나 끝나면 예외 발생")
    void exceptionIfStartOrEndWithDelimiter() {
        String input1 = ",alice,bob,john";
        String input2 = "alice,bob,john,";
        String input3 = ",alice,bob,john,";

        assertThrows(IllegalArgumentException.class, () -> validateInputString(input1));
        assertThrows(IllegalArgumentException.class, () -> validateInputString(input2));
        assertThrows(IllegalArgumentException.class, () -> validateInputString(input3));
    }

    @Test
    @DisplayName("참가자가 2명 미만인 경우 예외 발생")
    void exceptionIfLessThanTwo() {
        List<String> name = List.of("alice");
        assertThatThrownBy(() -> validateNameCount(name.size()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하거나 빈 문자열일 경우 예외 발생")
    void testIfNameLengthNotInRange() {
        String name1 = "racingCar";
        String name2 = "";

        assertThatThrownBy(() -> validateNameLength(name1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateNameLength(name2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}