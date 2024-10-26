package racingcar.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarServiceTest {

    RacingCarService racingCarService = new RacingCarService();

    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaj,pobi", "pobi,javaji"})
    void 이름_형식_예외(String argument) {
        assertThrows(IllegalArgumentException.class, () -> racingCarService.isValidateCarName(argument));
    }
}