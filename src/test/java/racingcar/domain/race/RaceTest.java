package racingcar.domain.race;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.random.FixedRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void 게임_생성() {
        // given
        Cars cars = new Cars("pobi,kim,kang");
        Race race = new Race(new FixedRandomNumberGenerator(4));

        // when
        List<String> winners = race.start(cars.getCars(), 5);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.getFirst()).isEqualTo("pobi");
    }
}
