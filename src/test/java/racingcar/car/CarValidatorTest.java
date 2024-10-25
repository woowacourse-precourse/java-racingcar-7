package racingcar.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarValidatorTest {
    @Test
    void 자동차_올바른_이름_검증() {
        List<String> sampleCorrectCarName = List.of(
                "a",
                "ab",
                "abc",
                "abcd",
                "abcde",
                " a ",
                " aaa ",
                "  a b c  ",
                "aaaa ",
                " abcd",
                "    abcde    ",
                "   aaaaa",
                "    d"

        );

        for (String carName : sampleCorrectCarName) {
            assertDoesNotThrow(() -> {
                new RacingCar(carName, 0);
            });
        }
    }

    @Test
    void 자동차_잘못된_이름_검증() {
        List<String> sampleIncorrectCarName = List.of(
                "",
                " ",
                "  ",
                "        ",
                "ab c d",
                "e   de ",
                "abcdeffff",
                "    e e e e e"
        );

        for (String carName : sampleIncorrectCarName) {
            assertThrows(IllegalArgumentException.class, () -> {
                new RacingCar(carName, 0);
            });
        }
    }
}
