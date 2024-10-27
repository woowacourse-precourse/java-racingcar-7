package racingcar.utils.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameException;

class CarNameValidatorTest {

    @Test
    @DisplayName("유효한 자동차 이름 입력 테스트")
    void shouldNotThrowExceptionForValidCarNames() {
        List<String> carNames = List.of("pobi", "crong", "honux");
        assertDoesNotThrow(() -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 입력되었을 경우")
    void shouldThrowExceptionForDuplicateCarNames() {
        List<String> carNames = List.of("pobi", "pobi", "HYPE");
        assertThrows(RacingGameException.DuplicatedCarNameException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 존재하는 경우")
    void shouldThrowExceptionForCarNameWithSpaces() {
        List<String> carNames = List.of("pobi", " pobi", "BOY");
        assertThrows(RacingGameException.BlankCarNameException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    @DisplayName("빈 자동차 이름이 입력되었을 경우")
    void shouldThrowExceptionForEmptyCarNames() {
        List<String> carNames = List.of("", "pobi", "jun");
        assertThrows(RacingGameException.CarNameEmptyInputException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5글자를 초과하는 경우")
    void shouldThrowExceptionForCarNameExceedingLength() {
        List<String> carNames = List.of("pobi", "pobi", "hypeboy");
        assertThrows(RacingGameException.InvalidNameLengthException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }
}