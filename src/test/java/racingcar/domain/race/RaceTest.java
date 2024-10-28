package racingcar.domain.race;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.random.FixedRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    public static final String USERS = "pobi,kim,kang";
    public static final int MOVABLE_VALUE = 4;

    @Test
    void 게임_실행_1회() {
        // given
        Cars cars = new Cars(USERS);
        Race race = new Race(new FixedRandomNumberGenerator(MOVABLE_VALUE));

        // when
        race.racing(cars);
        final List<String> winners = cars.winners();

        // then
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 게임_실행_10회() {
        // given
        Cars cars = new Cars(USERS);
        Race race = new Race(new FixedRandomNumberGenerator(MOVABLE_VALUE));
        int repetitions = 10;

        // when
        for (int i = 0; i < repetitions; i++) {
            race.racing(cars);
        }
        final List<String> winners = cars.winners();

        // then
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 게임_실행_5회() {
        // given
        Cars cars = new Cars(USERS);
        Race race = new Race(new FixedRandomNumberGenerator(MOVABLE_VALUE));
        int repetitions = 5;

        // when
        for (int i = 0; i < repetitions; i++) {
            race.racing(cars);
        }
        final List<String> winners = cars.winners();

        // then
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isEqualTo(3);
    }
}
