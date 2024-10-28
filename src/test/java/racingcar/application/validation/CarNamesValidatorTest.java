package racingcar.application.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
    public void 자동차가_한대만_있으면_예외를_던진다(String rawCarNames) throws Exception {
        //given
        CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNamesValidator.validate(rawCarNames));
    }

    @Test
    public void 자동차이름이_6자리_이상이면_예외를_던진다() throws Exception {
        //given
        CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNamesValidator.validate("pobi,abcdef"));
    }

    @Test
    public void 자동차이름이_중복되면_예외를_던진다() throws Exception {
        //given
        CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNamesValidator.validate("pobi,woni,pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,", "pobi, ", "pobi,\n", "pobi,\t", ",pobi", "pobi,,woni",
        "pobi, ,woni"})
    public void 자동차이름중_공백이_있으면_예외를_던진다(String carName) throws Exception {
        //given
        CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> carNamesValidator.validate(carName));
    }
}