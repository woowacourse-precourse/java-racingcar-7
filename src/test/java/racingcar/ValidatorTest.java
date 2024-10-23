package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("유효한 자동차 이름과 시도 횟수를 입력하면 예외가 발생하지 않음")
    void 정상입력케이스() {
        // given
        UserInput userInput = new UserInput("pobi,woni,jun", "5"); // 정상 입력
        Validator validator = new Validator();

        // when & then
        assertDoesNotThrow(() -> {
            validator.validateInput(userInput);  // 예외가 발생하지 않으면 통과
        });
    }

    @Test
    @DisplayName("자동차 이름을 1개 이상 입력하지 않으면 예외 발생")
    void 자동차입력최소1개() {
        // given
        UserInput userInput = new UserInput("", "3"); // 빈 자동차 이름 입력
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);  // 예외 발생 예상
        });

        assertEquals("자동차 이름은 1개 이상 입력해야 합니다.", exception.getMessage());  // 예외 메시지 검증
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외 발생")
    void 시도횟수1미만예외() {
        // given
        UserInput userInput = new UserInput("pobi,woni,jun", "0"); // 시도 횟수 0 입력
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);  // 예외 발생 예상
        });

        assertEquals("시도 횟수는 1 이상이어야 합니다.", exception.getMessage());  // 예외 메시지 검증
    }
}