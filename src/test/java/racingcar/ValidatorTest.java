package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorTest extends NsTest {

    @Test
    void testValidCarNames() {
        assertDoesNotThrow(() -> Validator.isValidCarsName("pobi,woni,jun"));
    }

    @Test
    void testInvalidCarNames() {
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidCarsName("pobi,woni,,"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidCarsName("pobiii,woni"));
    }

    @Test
    void testValidTurn() {
        assertDoesNotThrow(() -> Validator.isValidTurn("5"));
        assertDoesNotThrow(() -> Validator.isValidTurn("05"));
    }

    @Test
    void testInvalidTurn() {
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidTurn("five"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
