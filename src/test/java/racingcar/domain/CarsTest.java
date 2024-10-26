package racingcar.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.utils.FixedNumberGenerator;

import java.util.List;

public class CarsTest {
    @Nested
    @DisplayName("객체 생성 테스트")
    class CarsCreateTest {
        @Test
        void 자동차는_2대_이상이여야_한다() {
            // given
            final List<String> carNames = List.of("pobi");

            // when, then
            assertThatThrownBy(() -> Cars.createFromCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차의 수는 2대 이상이어야 합니다.");
        }
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
    }
    @Nested
    @DisplayName("기능 테스트")
    class CarsMethodTest {
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

        @Test
        void 시도횟수만큼_라운드_진행() {
            // given
            final int tryCount = 4;

            final List<Car> carsList = List.of(
                    new Car("pobi", new FixedNumberGenerator(List.of(1,2,3,4))),
                    new Car("woni", new FixedNumberGenerator(List.of(5,6,7,8)))
            );

            final Cars cars = Cars.createFromCarsList(carsList);

            // when
            range(0, tryCount)
                    .forEach(round -> cars.play());

            final List<Car> actual = cars.getCars();
            final List<Car> expected = List.of(new Car("pobi", 1), new Car("woni", 4));

            // then
            assertThat(actual)
                    .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
                    .containsExactlyInAnyOrderElementsOf(expected);
        }
    }
}
