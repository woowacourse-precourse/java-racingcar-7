package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputStringValidatorTest {

    @Test
    void isEmpty_Empty_Error() {
        // Given: 빈 문자열
        String emptyCarName = "";

        // When: isEmpty 메서드 호출
        // Then: 예외 발생, 메세지 검증
        assertThatThrownBy(() -> InputStringValidator.isEmpty(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해야 합니다.");
    }

    @Test
    void isEmpty_NotEmpty_NotError() {
        // Given: 유효한 문자열이 주어짐
        String validCarName = "Mike,John";

        // When: isEmpty 메서드 호출
        // Then: 정상 동작
        InputStringValidator.isEmpty(validCarName);
    }
}
