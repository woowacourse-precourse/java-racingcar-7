package racingcar.application.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
    public void 자동차이름이_1자리이상_5자리이하면_통과된다(String carName) throws Exception {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();

        //when
        //then
        assertDoesNotThrow(() -> carNameValidator.validate(carName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    public void 자동차이름이_공백이면_예외를_던진다(String carName) throws Exception {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNameValidator.validate(carName));
    }

    @Test
    public void 자동차이름이_6자리_이상이면_예외를_던진다() throws Exception {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNameValidator.validate("abcdef"));
    }
}