package racingcar.application.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "50"})
    public void 횟수가_1이상_50이하이면_통과한다(String count) throws Exception {
        //given
        CountValidator countValidator = new CountValidator();

        //when
        //then
        assertDoesNotThrow(() -> countValidator.validate(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1", "1 ", " 50", "50 ", " 50 "})
    public void 횟수_입력의_앞뒤로_공백이_있더라도_숫자면_통과한다(String count) throws Exception {
        //given
        CountValidator countValidator = new CountValidator();

        //when
        //then
        assertDoesNotThrow(() -> countValidator.validate(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "51"})
    public void 횟수가_1이상_50이하가_아니면_예외를_던진다(String count) throws Exception {
        //given
        CountValidator countValidator = new CountValidator();
        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> countValidator.validate(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    public void 횟수가_공백이면_예외를_던진다(String count) throws Exception {
        //given
        CountValidator countValidator = new CountValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> countValidator.validate(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "a1"})
    public void 횟수에_문자가_있으면_예외를_던진다(String count) throws Exception {
        //given
        CountValidator countValidator = new CountValidator();

        //when
        //then
        assertThrows(IllegalArgumentException.class,
            () -> countValidator.validate(count));
    }
}