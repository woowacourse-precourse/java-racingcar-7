package racingcar.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    public static final String CAR_NAMES = "pobi,woni,jun";
    public static final String CAR_NAMES_WITH_SPACE = "pobi,wo ni, ju n";
    public static final String CAR_NAME_OVER_5  = "making";
    private static final String ATTEMPT_COUNT = "3";


    @Test
    @DisplayName("유효한 자동차 이름과 시도 횟수를 입력하면 예외가 발생하지 않는다.")
    void 올바른입력() {
        // given
        UserInput userInput = new UserInput(CAR_NAMES, ATTEMPT_COUNT);
        Validator validator = new Validator();

        // when & then
        assertDoesNotThrow(() -> {
            validator.validateInput(userInput);
        });
    }

    @Test
    @DisplayName("자동차 이름을 1개 이상 입력하지 않으면 예외가 발생한다.")
    void 자동차입력_최소1개() {
        // given
        UserInput userInput = new UserInput("", ATTEMPT_COUNT);
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);
        });

        assertEquals("자동차 이름은 1개 이상 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 공백을 포함하면 예외가 발생한다.")
    void 자동차입력_공백() {
        // given
        UserInput userInput = new UserInput(CAR_NAMES_WITH_SPACE, ATTEMPT_COUNT);
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);
        });

        assertEquals("자동차 이름에 공백은 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름을 5글자 이상 입력하면 예외가 발생한다.")
    void 자동차입력_5글자이상() {
        // given
        UserInput userInput = new UserInput(CAR_NAME_OVER_5,  ATTEMPT_COUNT);
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);
        });

        assertEquals("각 자동차 이름은 5글자 이하로 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 1 이상 입력하지 않으면 예외가 발생한다.")
    void 시도횟수_최소1() {
        // given
        UserInput userInput = new UserInput(CAR_NAMES, "0");
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);
        });

        assertEquals("시도 횟수는 1 이상 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니라면 예외가 발생한다.")
    void 시도횟수_숫자만가능() {
        // given
        UserInput userInput = new UserInput(CAR_NAMES, "shouldBeNumber");
        Validator validator = new Validator();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(userInput);
        });

        assertEquals("시도 횟수는 숫자로 입력해야 합니다.", exception.getMessage());
    }
}