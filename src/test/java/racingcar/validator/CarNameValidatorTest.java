package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("CarNameValidator 검증 테스트")
class CarNameValidatorTest {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    @DisplayName("빈 문자열이 입력되면 예외를 발생시킨다.")
    @Test
    void fail1() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(input));
    }

    @DisplayName("자동차 이름이 1개만 입력되었을 경우 예외를 발생시킨다.")
    @Test
    void fail2() {
        String input = "  , pobi, ";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(input));
    }

    @DisplayName("쉼표가 아닌 문자를 사용해서 이름을 구별할 경우 예외를 발생시킨다.")
    @Test
    void fail3() {
        String input = "pobi/woni/jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(input));
    }

    @DisplayName("자동차 이름이 5자가 초과되는 경우 예외를 발생시킨다.")
    @Test
    void fail4() {
        String input = "hellomycar, goodcar, pobi";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(input));
    }

    @DisplayName("자동차 이름이 중복으로 입력된 경우 예외를 발생시킨다.")
    @Test
    void fail5() {
        String input = "pobi, jun, pobi, woni";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(input));
    }

    @DisplayName("자동차 이름이 5자 이하인 경우 예외가 발생하지 않는다.")
    @Test
    void success1() {
        String input = "pobi, woni, jun";
        assertDoesNotThrow(() -> carNameValidator.validate(input));
    }
}