package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("정상 입력 - 여러 참가자")
    void validateAndParseCarNames_withValidInputMultipleParticipants() {
        String input = "alice,bob,kang,dave";
        List<String> result = InputValidator.validateAndParseCarNames(input);
        assertThat(result).containsExactly("alice", "bob", "kang", "dave");
    }

    @Test
    @DisplayName("정상 입력 - 단일 참가자")
    void validateAndParseCarNames_withValidInputSingleParticipant() {
        String input = "alice";
        List<String> result = InputValidator.validateAndParseCarNames(input);
        assertThat(result).containsExactly("alice");
    }

    @Test
    @DisplayName("입력값이 비어 있을 때 예외 발생")
    void validateAndParseCarNames_withEmptyInput() {
        String input = "";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있어서 레이스를 시작할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 양 끝에 쉼표가 있을 때 예외 발생")
    void validateAndParseCarNames_withLeadingOrTrailingComma() {
        String input = ",alice,bob,charlie,";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 양 끝에 쉼표가 올 수 없습니다.");
    }

    @Test
    @DisplayName("이름 사이에 연속된 쉼표가 있을 때 예외 발생")
    void validateAndParseCarNames_withConsecutiveCommas() {
        String input = "alice,,,,,,,bob";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 사이에 연속된 쉼표가 올 수 없습니다.");
    }

    @Test
    @DisplayName("참가자가 20명을 초과할 때 예외 발생")
    void validateAndParseCarNames_withExceedingParticipants() {
        String input = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 최대 20명까지만 허용됩니다.");
    }

    @Test
    @DisplayName("이름에 특수 문자가 포함될 때 예외 발생")
    void validateAndParseCarNames_withSpecialCharacters() {
        String input = "alice,bob,$@#!";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 영어 소문자, 대문자, 숫자, 그리고 콤마만 가능합니다.");
    }

    @Test
    @DisplayName("이름이 5자를 초과할 때 예외 발생")
    void validateAndParseCarNames_withNameExceedingMaxLength() {
        String input = "alice,excessivelongname";
        assertThatThrownBy(() -> InputValidator.validateAndParseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다");
    }

    @Test
    @DisplayName("입력값의 모든 공백이 제거되어 처리됨")
    void validateAndParseCarNames_withSpacesInInput() {
        String input = "   alice,   bob , kang   ";
        List<String> result = InputValidator.validateAndParseCarNames(input);
        assertThat(result).containsExactly("alice", "bob", "kang");
    }

    @Test
    @DisplayName("정상 시도 횟수 입력")
    void validateAttempts_withValidInput() {
        String input = "15";
        String result = InputValidator.validateAttempts(input);
        assertThat(result).isEqualTo("15");
    }

    @Test
    @DisplayName("시도 횟수가 비어 있을 때 예외 발생")
    void validateAttempts_withEmptyInput() {
        String input = "";
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있어서 레이스를 시작할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 예외 발생")
    void validateAttempts_withNonNumericInput() {
        String input = "abc";
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 반드시 숫자만 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 24를 초과할 때 예외 발생")
    void validateAttempts_withExceedingAttempts() {
        String input = "25";
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0 이상 24 이하여야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 음수일 때 예외 발생")
    void validateAttempts_withNegativeAttempts() {
        String input = "-5";
        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 반드시 숫자만 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력값의 모든 공백이 제거된 후 정상 시도 횟수 처리")
    void validateAttempts_withSpacesInInput() {
        String input = "   12   ";
        String result = InputValidator.validateAttempts(input);
        assertThat(result).isEqualTo("12");
    }
}