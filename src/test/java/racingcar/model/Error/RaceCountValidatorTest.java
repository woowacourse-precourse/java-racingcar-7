package racingcar.model.Error;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaceCountValidatorTest {

    private RaceCountValidator raceCountValidator;

    @BeforeEach
    void setUp() {
        raceCountValidator = new RaceCountValidator();
    }

    @Test
    void 유효한_레이스_횟수_입력_테스트() {
        String input = "5";
        int result = raceCountValidator.validateRaceNum(input);
        assertEquals(5, result);
    }

    @Test
    void 빈_입력_값_테스트() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            raceCountValidator.validateRaceNum(input);
        });
    }

    @Test
    void 숫자가_아닌_값_입력_테스트() {
        String input = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            raceCountValidator.validateRaceNum(input);
        });
    }

    @Test
    void 음수_값_입력_테스트() {
        String input = "-5";
        assertThrows(IllegalArgumentException.class, () -> {
            raceCountValidator.validateRaceNum(input);
        });
    }
}
