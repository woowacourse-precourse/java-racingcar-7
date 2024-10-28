package racingcar.game.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.game.error.ErrorMessage;

@DisplayName("RacingCars 를 테스트한다.")
class RacingCarsTest {

    @DisplayName("성공 테스트를 검증한다.")
    @Nested
    class HappyCase {

        @DisplayName("동일한 자동차가 존재하지 않으면 성공한다.")
        @Test
        void testRacingCars1() {
            // given
            List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));

            // when
            RacingCars racingCars = new RacingCars(cars);

            // then
            assertThat(racingCars).isNotNull();
        }

        @DisplayName("임시 경주 결과의 개수가 참여한 자동차 수와 같으면 성공한다.")
        @Test
        void testRacingCar2() {
            // given
            List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
            RacingCars racingCars = new RacingCars(cars);

            // when
            racingCars.race();
            List<RaceSnapshot> snapshots = racingCars.getCurrentSnapshots();

            // then
            assertThat(cars.size()).isEqualTo(snapshots.size());
        }

        @DisplayName("임시 경주 결과 자동차의 이름 순서가 참여한 자동차 이름 순서와 동일하면 성공한다.")
        @Test
        void testRacingCar3() {
            // given
            List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
            RacingCars racingCars = new RacingCars(cars);

            // when
            racingCars.race();
            List<RaceSnapshot> snapshots = racingCars.getCurrentSnapshots();

            // then
            assertThat(snapshots)
                    .extracting("carName")
                    .containsExactly("car1", "car2", "car3");
        }
    }

    @DisplayName("실패 테스트를 검증한다.")
    @Nested
    class EdgeCase {

        @DisplayName("동일한 자동차가 존재하면 실패한다.")
        @Test
        void testRacingCars1() {
            // given
            List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car2"));

            // when & then
            assertThatThrownBy(() -> new RacingCars(cars))
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.CANNOT_PARTICIPATE_DUPLICATE_CAR.getDescription());
        }
    }
}