package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    private List<String> cars;

    static class FixedNumberGenerator implements NumberGenerator {
        private int number;

        public FixedNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generateNumber() {
            return number;
        }
    }

    @BeforeEach
    void setUp() {
        cars = List.of("도현", "현도");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_해주라(int number) {
        Race race = new Race(cars, new FixedNumberGenerator(number));

        race.playSingleRound();

        race.getCars().forEach(car -> assertThat(car.getMoveDistance()).isEqualTo(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_전진_하면안됨제발(int number) {
        Race race = new Race(cars, new FixedNumberGenerator(number));

        race.playSingleRound();

        race.getCars().forEach(car -> assertThat(car.getMoveDistance()).isEqualTo(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 움직인_한_라운드_테스트(int number) {
        Race race = new Race(cars, new FixedNumberGenerator(number));

        race.playSingleRound();

        assertThat(race.getSingleRoundResult()).isEqualTo(List.of(
                "도현 : -",
                "현도 : -"
        ));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 안_움직인_한_라운드_테스트(int number) {
        Race race = new Race(cars, new FixedNumberGenerator(number));

        race.playSingleRound();

        assertThat(race.getSingleRoundResult()).isEqualTo(List.of(
                "도현 : ",
                "현도 : "
        ));
    }
}
