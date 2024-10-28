package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import racingcar.validator.CarValidator;

import java.util.HashSet;
import java.util.Set;

class CarValidatorTest {

    private Set<String> existingNames;

    @BeforeEach
    void setUp() {
        existingNames = new HashSet<>();
    }

    @Test
    void validateCarName_ShouldThrowException_WhenNameIsTooLong() {
        String invalidName = "TooLongName";

        assertThatThrownBy(() -> CarValidator.validateCarName(invalidName, existingNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void validateCarName_ShouldThrowException_WhenNameIsEmpty() {
        String invalidName = "";

        assertThatThrownBy(() -> CarValidator.validateCarName(invalidName, existingNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1글자 이상부터 가능합니다.");
    }

    @Test
    void validateCarName_ShouldThrowException_WhenNameIsDuplicate() {
        String duplicateName = "Car1";
        existingNames.add(duplicateName);

        assertThatThrownBy(() -> CarValidator.validateCarName(duplicateName, existingNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void validateAttempts_ShouldThrowException_WhenAttemptsIsNotNumber() {
        String invalidAttempts = "abc";

        assertThatThrownBy(() -> CarValidator.validateAttempts(invalidAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 숫자여야 합니다.");
    }

    @Test
    void validateAttempts_ShouldThrowException_WhenAttemptsIsZeroOrNegative() {
        String invalidAttempts = "0";

        assertThatThrownBy(() -> CarValidator.validateAttempts(invalidAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
