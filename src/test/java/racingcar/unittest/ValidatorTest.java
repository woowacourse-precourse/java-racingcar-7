package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Validator;

class ValidatorTest extends NsTest {

    @Test
    @DisplayName("유효한 자동차 이름 검증 테스트")
    void validateCarNames_withValidNames_shouldPass() {
        // Given
        String[] names = {"pobi", "crong", "honux"};

        // When & Then
        assertThatCode(() -> Validator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열인 경우 예외 발생 테스트")
    void validateCarNames_withEmptyName_shouldThrowException() {
        // Given
        String[] names = {"", ""};

        // When & Then
        assertThatThrownBy(() -> Validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생 테스트")
    void validateCarNames_withNameLongerThanFive_shouldThrowException() {
        // Given
        String[] names = {"pobi123", "pobi1234"};

        // When & Then
        assertThatThrownBy(() -> Validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는 경우 예외 발생 테스트 (대소문자 구분 없이)")
    void validateCarNames_withDuplicateNames_shouldThrowException() {
        // Given
        String[] names = {"pobi", "crong", "Pobi"};

        // When & Then
        assertThatThrownBy(() -> Validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 중복이 존재합니다");
    }

    @Test
    @DisplayName("자동차 이름 배열이 비어 있는 경우 예외 발생 테스트")
    void validateCarNames_withEmptyArray_shouldThrowException() {
        // Given
        String[] names = {};

        // When & Then
        assertThatThrownBy(() -> Validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("적어도 두 대의 자동차 이름을 입력해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 하나만 입력된 경우 예외 발생 테스트")
    void validateCarNames_withSingleCarName_shouldThrowException() {
        // Given
        String[] names = {"pobi"};

        // When & Then
        assertThatThrownBy(() -> Validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("적어도 두 대의 자동차 이름을 입력해야 합니다.");
    }


    @Test
    @DisplayName("시도 횟수가 양의 정수인 경우 검증 통과 테스트")
    void validateAttempts_withPositiveInteger_shouldPass() {
        // Given
        int attempts = 5;

        // When & Then
        assertThatCode(() -> Validator.validateAttempts(attempts))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 0 이하인 경우 예외 발생 테스트")
    void validateAttempts_withNonPositiveInteger_shouldThrowException() {
        // Given
        int attempts = 0;

        // When & Then
        assertThatThrownBy(() -> Validator.validateAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 한 개의 양의 정수여야 합니다:");
    }

    @Override
    public void runMain() {
    }
}
