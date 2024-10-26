package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.utils.FixedNumberGenerator;

import java.util.List;

public class CarsTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        // given
        final List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        final Cars cars = Cars.createFromCarNames(carNames);

        final List<Car> actual = cars.getCars();
        final List<Car> expected = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        // then
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void 무작위_값이_4_이상일_경우_전진한다() {
        // given
        final List<Car> carsList = List.of(
                new Car("pobi", new FixedNumberGenerator(4)), new Car("woni", new FixedNumberGenerator(0)));

        // when
        final Cars cars = Cars.createFromCarsList(carsList);
        cars.play();

        final List<Car> actual = cars.getCars();
        final List<Car> expected = List.of(
                new Car("pobi", 1), new Car("woni", 0)
        );

        // then
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
                .containsExactlyInAnyOrderElementsOf(expected);

    }
}
