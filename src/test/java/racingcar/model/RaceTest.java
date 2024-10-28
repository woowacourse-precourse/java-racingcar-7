package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RaceTest {

    @Test
    void 자동차_이름이_주어졌을_때() {
        Race race = new Race("sisu,java", "3");
        assertThat(race.getRacingCars().stream().map(Car::getName).toList()).containsExactly("sisu", "java");
    }

    @ParameterizedTest
    @CsvSource(value = {"longNameTest,test,java,sisu:3", "java jigi,test,java,sisu:3"}, delimiter = ':')
    void 자동차_이름이_5자_초과일_때(String carNames, String roundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(carNames, roundInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"'':3", ",sisu:3", "sisu,:3", "sisu,,java:3", "sisu,,:3", ",,sisu:3"}, delimiter = ':')
    void 이름이_없는_입력값이_주어질_때(String carName, String roundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(carName, roundInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"sisu,sisu:3", "java,java,java:1"}, delimiter = ':')
    void 중복되는_이름이_있을_때(String racingCarNames, String roundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(racingCarNames, roundInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"sisu,I'm not an integer", "sisu,", "sisu,3.0", "sisu,!"})
    void 정수가_아닌_값이_round_인자로_주어졌을_때(String carName, String roundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(carName, roundInput);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"sisu:-1", "sisu:0", "sisu:10000000000000000000"}, delimiter = ':')
    void 범위를_벗어난_값이_round_인자로_주어졌을_때(String carNames, String roundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(carNames, roundInput);
        });
    }
}
