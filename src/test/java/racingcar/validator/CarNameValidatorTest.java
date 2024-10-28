package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void 공백_포함_문자열(String input) {
        assertDoesNotThrow(() -> carNameValidator.validateCarNamesInput(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 예외_테스트_빈_입력_문자열(String input) {
        assertThatThrownBy(() -> carNameValidator.validateCarNamesInput(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 자동차_2대_이상() {
        String[] carNames = {"car1", "car2"};
        assertDoesNotThrow(() -> carNameValidator.validateCarNames(carNames));
    }

    @Test
    void 예외_테스트_자동차_1대_이하() {
        String[] carNames = {"car1"};
        assertThatThrownBy(() -> carNameValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 기본_자동차_이름() {
        String[] carNames = {"car1", "car2"};
        String[] validatedCarNames = carNameValidator.validateCarNames(carNames);
        assertThat(validatedCarNames).containsExactly("car1", "car2");
    }

    @Test
    void 공백_포함_자동차_이름() {
        String[] carNames = {"car1", "    car2"};
        String[] validatedCarNames = carNameValidator.validateCarNames(carNames);
        assertThat(validatedCarNames).containsExactly("car1", "car2");
    }

    @Test
    void 예외_테스트_빈_자동차_이름() {
        String[] carNames = {"car1, ,car3"};
        assertThatThrownBy(() -> carNameValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_글자_수_초과_자동차_이름() {
        String[] carNames = {"car123456", "car5"};
        assertThatThrownBy(() -> carNameValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 중복_미포함_자동차_이름() {
        String[] carNames = {"car1", "car2", "car7"};
        assertDoesNotThrow(() -> carNameValidator.validateCarNames(carNames));
    }

    @Test
    void 중복_포함_자동차_이름() {
        String[] carNames = {"car1", "car1", "car2"};
        assertThatThrownBy(() -> carNameValidator.validateCarNames(carNames)).isInstanceOf(
                IllegalArgumentException.class);
    }

}