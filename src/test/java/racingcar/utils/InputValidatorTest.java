package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("앞뒤 공백을 포함한 문자열에서 모든 공백을 제거")
    void testRemoveAllSpaces_withLeadingAndTrailingSpaces() {
        String input = "    Hello  World    ";
        String result = InputValidator.removeAllSpaces(input);
        assertThat(result).isEqualTo("HelloWorld");
    }

    @Test
    @DisplayName("모든 종류의 공백 문자 (탭, 줄바꿈 등) 제거 테스트")
    void testRemoveAllSpaces_withVariousWhitespaceCharacters() {
        String input = "Hello\tWorld\nNew Line";
        String result = InputValidator.removeAllSpaces(input);
        assertThat(result).isEqualTo("HelloWorldNewLine");
    }

    @Test
    @DisplayName("공백만 포함된 문자열에 대한 공백 제거 테스트")
    void testRemoveAllSpaces_withOnlySpaces() {
        String input = "       ";
        String result = InputValidator.removeAllSpaces(input);
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("빈 문자열에 대한 공백 제거 테스트")
    void testRemoveAllSpaces_withEmptyString() {
        String input = "";
        String result = InputValidator.removeAllSpaces(input);
        assertThat(result).isEqualTo("");
    }
}