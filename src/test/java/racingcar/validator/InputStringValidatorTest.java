package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputStringValidatorTest {

    @Test
    void isEmpty_Empty_Error() {
        // Given: 빈 문자열
        String emptyCarNameString = "";

        // When: isEmpty 메서드 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> InputStringValidator.carNameIsEmpty(emptyCarNameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해야 합니다.");
    }

    @Test
    void isEmpty_NotEmpty_NotError() {
        // Given: 유효한 문자열이 주어짐
        String validCarNameString = "Mike,John";

        // When: isEmpty 메서드 호출
        // Then: 정상 동작
        InputStringValidator.carNameIsEmpty(validCarNameString);
    }

    @Test
    public void attemptCountIntegratedValidation_EmptyAttemptCount_Error() {
        // Given: 시도 횟수 공백 입력
        String emptyAttemptCount = "";

        // When: attemptCountIntegratedValidation(String userInputAttemptCount) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> InputStringValidator.attemptCountIntegratedValidation(emptyAttemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수가 입력되지 않았습니다.");
    }

    @Test
    public void attemptCountIntegratedValidation_NotNumberAttemptCount_Error() {
        // Given: 시도 횟수 문자 입력
        String notNumberAttemptCount = "십";

        // When: attemptCountIntegratedValidation(String userInputAttemptCount) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> InputStringValidator.attemptCountIntegratedValidation(notNumberAttemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자로 입력되어야 합니다.");
    }

    @Test
    public void attemptCountIntegratedValidation_NegativeNumberAttemptCount_Error() {
        // Given: 시도 횟수 음수 입력
        String negativeAttemptCount = "-10";

        // When: attemptCountIntegratedValidation(String userInputAttemptCount) 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> InputStringValidator.attemptCountIntegratedValidation(negativeAttemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이상의 숫자를 입력해 주세요.");
    }

    @Test
    public void attemptCountIntegratedValidation_ValidAttemptCount_NotError() {
        // Given: 유효한 시도 횟수
        String validAttemptCount = "5";

        // When: attemptCountIntegratedValidation(String userInputAttemptCount) 호출
        // Then: 정상 동작
        InputStringValidator.attemptCountIntegratedValidation(validAttemptCount);
    }
}
