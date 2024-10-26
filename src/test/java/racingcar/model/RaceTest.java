package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    static class FixedNumberGenerator implements NumberGenerator {
        private int number;

        @Override
        public int generateNumber() {
            return number;
        }

        private void setNumber(int number) {
            this.number = number;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_해주라(int number) {
        var cars = List.of("도현", "현도");
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator();
        numberGenerator.setNumber(number);
        Race race = new Race(cars, numberGenerator);

        race.playOneRound();

        race.getCars().forEach(car -> assertThat(car.getMoveDistance()).isEqualTo(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_전진_하면안됨제발(int number) {
        var cars = List.of("도현", "현도");
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator();
        numberGenerator.setNumber(number);
        Race race = new Race(cars, numberGenerator);

        race.playOneRound();

        race.getCars().forEach(car -> assertThat(car.getMoveDistance()).isEqualTo(0));
    }
}
