package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidLengthException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class VerificationServiceTest {

    private VerificationService verificationService;

    @BeforeEach
    void setUp() {
        verificationService = new VerificationService();
    }

    @Test
    void isValidLength() {
        List<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("bc");
        carNames.add("def");
        carNames.add("ghij");
        carNames.add("klmno");
        assertTrue(verificationService.isValidLength(carNames));
    }

    @Test
    void isValidLengthException() {
        List<String> invalidCarNames = new ArrayList<>();
        invalidCarNames.add("abcdef");
        invalidCarNames.add("ghijklmnopqrstuvwxyz");
        assertThrows(InvalidLengthException.class, () -> verificationService.isValidLength(invalidCarNames));
    }

    @Test
    void containsInvalidCharacter() {
        String input = "1abc,def,ghijk";
        assertTrue(verificationService.containsInvalidCharacter(input));
    }

    @Test
    void containsInvalidCharacterException() {
        String input = "^1abc,def,*ghijk";
        assertThrows(InvalidCharacterException.class, () -> verificationService.containsInvalidCharacter(input));
    }
}