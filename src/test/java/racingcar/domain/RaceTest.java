package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RaceTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        // given
        final List<Car> cars = List.of(
                new Car("pobi"), new Car("woni"), new Car("jun"));

        // when
        final Cars race = new Cars(cars);

        // then
        assertThat(race.getCars())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(cars);
    }

    @Test
    void 무작위_값이_4_이상일_경우_전진한다() {
        // given
        final List<Car> cars = List.of(
                new Car("pobi", new FixedNumberGenerator(4)), new Car("woni", new FixedNumberGenerator(0)));

        // when
        final Cars race = new Cars(cars);

        race.start();

        final List<Car> expected = List.of(
                new Car("pobi", 1), new Car("woni", 0)
        );
        final List<Car> actual = race.getCars();

        // then
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
                .containsExactlyInAnyOrderElementsOf(expected);

    }
}
