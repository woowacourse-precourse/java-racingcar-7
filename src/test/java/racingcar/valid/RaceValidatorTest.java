package racingcar.valid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RaceValidatorTest {

    @Test
    void validateCarName() {
        String[] names1 = {"pobi", "woni","junnnnn"};
        String[] names2 = {"pobi","woni","jun"};

        Assertions.assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateCarName(names1));
        Assertions.assertDoesNotThrow(() -> RaceValidator.validateCarName(names2));
    }

    @Test
    void validateRaceCount() {
        String count1 = " ";
        String count2 = null;
        String count3 = "-1";
        String count4 = "2";

        Assertions.assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateRaceCount(count1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateRaceCount(count2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateRaceCount(count3));
        Assertions.assertDoesNotThrow(() -> RaceValidator.validateRaceCount(count4));
    }
}