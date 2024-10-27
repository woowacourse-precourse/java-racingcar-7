package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.RandomCar;

class CarsTest {
    @Nested
    class TestMoveAll {
        @ParameterizedTest
        @ValueSource(ints = {0, 10, 20, 30, 100, 1_000})
        void should_increase_cars_position_in_range_0_to_move_count(int moveCount) {
            // given
            Cars cars = new Cars(List.of("car1", "car2", "car3"), RandomCar::new);

            // when
            for (int i = 0; i < moveCount; i++) {
                cars.moveAll();
            }

            // then
            assertThat(cars.values).allMatch(car -> car.getPosition() >= 0 && car.getPosition() <= moveCount);
        }

        // Yeah, this test is not deterministic. But without test doubles, it's my best shot.
        @Test
        void maybe_increase_cars_position_in_many_trials() {
            // given
            Cars cars = new Cars(List.of("car1", "car2", "car3"), RandomCar::new);
            final int TRIAL_COUNT = 1_000;

            // when
            for (int i = 0; i < TRIAL_COUNT; i++) {
                cars.moveAll();
            }

            // then
            assertThat(cars.values).allMatch(car -> car.getPosition() > 0);
        }
    }

    @Nested
    class TestGetAllFarthest {
        @Test
        void should_return_all_cars_when_no_moves() {
            // given
            Cars cars = new Cars(List.of("car1", "car2", "car3"), RandomCar::new);

            // when
            List<Car> actual = cars.getAllFarthest();

            // then
            assertThat(actual.size()).isEqualTo(3);
        }

        @RepeatedTest(10)
        void should_return_list_contain_farthest_car() {
            // given
            Cars cars = new Cars(List.of("car1", "car2", "car3"), RandomCar::new);
            cars.moveAll();
            cars.moveAll();
            cars.moveAll();

            // when
            List<Car> actual = cars.getAllFarthest();

            // then
            Car farthest = cars.values.stream().max(Car::compareTo).orElseThrow();
            assertThat(actual).contains(farthest);
        }
    }

    @Nested
    class TestToString {
        @Test
        void should_no_dashes_without_move() {
            // given
            Cars cars = new Cars(List.of("car1", "car2", "car3"), RandomCar::new);

            // when
            String actual = cars.toString();

            // then
            assertThat(actual).isEqualTo("car1 : \ncar2 : \ncar3 : ");
        }

        @RepeatedTest(10)
        void should_have_dashes_with_move() {
            // given
            Cars cars = new Cars(List.of("car1", "car2"), RandomCar::new);
            while (cars.values.getFirst().getPosition() == 0) {
                cars.moveAll();
            }

            // when
            String actual = cars.toString();

            // then
            assertThat(actual).contains("-");
            assertThat(actual).isEqualTo(cars.values.getFirst() + "\n" + cars.values.getLast());
        }
    }
}
