package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;

public class RaceTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        // given
        final List<String> carNames = List.of("pobi", "woni", "jun");
        final Race race = new Race(carNames);

        // when
        final List<Car> expected = List.of(
                new Car("pobi"), new Car("woni"), new Car("jun"));
        final List<Car> actual = race.getCars();

        // then
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected);
    }
}
