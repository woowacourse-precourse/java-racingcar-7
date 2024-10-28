package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    @DisplayName("난수는 0과 9 사이의 숫자가 반환되어야 한다.")
    void generateRandomNumber_shouldReturnNumberInRange() {
        // Given
        int iterations = 100;

        // When & Then
        for (int i = 0; i < iterations; i++) {
            int randomNumber = Util.generateRandomNumber();
            assertThat(randomNumber).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열이 리스트로 변환되어야 한다.")
    void splitByComma_shouldReturnListOfStrings() {
        // Given
        String input = "pobi, woni, jun";
        List<String> expected = List.of("pobi", "woni", "jun");

        // When
        List<String> result = Util.splitByComma(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("공백이 포함된 문자열이 처리되어야 한다.")
    void splitByComma_shouldTrimSpaces() {
        // Given
        String input = "  pobi  ,  woni  ,  jun  ";
        List<String> expected = List.of("pobi", "woni", "jun");

        // When
        List<String> result = Util.splitByComma(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("빈 문자열을 처리할 수 있어야 한다.")
    void splitByComma_shouldHandleEmptyString() {
        // Given
        String input = "";
        List<String> expected = List.of();

        // When
        List<String> result = Util.splitByComma(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("단일 항목 문자열이 리스트로 변환되어야 한다.")
    void splitByComma_shouldHandleSingleEntry() {
        // Given
        String input = "pobi";
        List<String> expected = List.of("pobi");

        // When
        List<String> result = Util.splitByComma(input);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
