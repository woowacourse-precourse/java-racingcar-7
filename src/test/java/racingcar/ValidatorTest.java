package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("사용자 입력 값(자동차 이름) 유효성 체크")
    public void testInputCarNameValidate() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobitest", "1"));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobitest,jun,pobitest", "1"));

        Exception exception3 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobitest, jun ,pobitest ", "1"));

        Exception exception4 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("", "1"));

        Exception exception5 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate(" ", "1"));

        Exception exception6 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("  ", "1"));
    }

    @Test
    @DisplayName("사용자 입력 값(시도 횟수) 유효성 체크")
    public void testInputCountValidate() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "dwdwqwqd123"));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "1.2"));

        Exception exception3 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "sfjkdsjfksdlfj"));

        Exception exception4 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "1@$2"));

        Exception exception5 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "1@$2"));

        Exception exception6 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", ".123ddfgd"));

        Exception exception7 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", ""));

        Exception exception8 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", " "));

        Exception exception9 = assertThrows(IllegalArgumentException.class, () ->
                validator.validate("pobi,woni,jun", "  "));
    }
}
