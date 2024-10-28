package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    private CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 공백_이름_입력() {
        assertThatCode(() -> carNameValidator.validate("woni,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a name that is not composed only of whitespace.");
    }

    @Test
    void 빈_이름_리스트_입력() {
        assertThatCode(() -> carNameValidator.validate(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a name that contains at least one character.");
    }

    @Test
    void 빈_이름_리스트_입력2() {
        assertThatCode(() -> carNameValidator.validate(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a name that contains at least one character.");
    }

    @Test
    void 길이_초과_이름() {
        assertThatCode(() -> carNameValidator.validate("woniwoni,bini,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a name with 5 characters of fewer.");
    }

    @Test
    void 중복_이름_입력() {
        assertThatCode(() -> carNameValidator.validate("woni,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a name that is not already in use.");
    }
}
