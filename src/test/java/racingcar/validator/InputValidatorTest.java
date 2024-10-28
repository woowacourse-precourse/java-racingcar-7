package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    public void carNameInputTest() {
        Assertions.assertDoesNotThrow(() -> {
            InputValidator.isStringOnly("pobi,woni,jun");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isStringOnly("p2bi,w0ni,jun");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isStringOnly("p@bi,won!,jun");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isStringOnly("pobi,,,woni,,jun");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isStringOnly("#$,pobi,woni;,#$2n");
        });
    }

    @Test
    public void tryMoveCountTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isNumberOnly("five");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isNumberOnly("5;@");
        });

        Assertions.assertDoesNotThrow(() -> {
            InputValidator.isNumberOnly("5");
        });
    }

}