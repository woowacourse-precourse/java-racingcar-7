package racingcar.game.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.game.error.ErrorMessage;

@DisplayName("Car 를 테스트한다.")
class CarTest {

    @DisplayName("성공 테스트를 검증한다.")
    @Nested
    class HappyCase {

        @DisplayName("Car 를 만드는데 성공한다.")
        @Test
        void testCar1() {
            // given
            String carName = "name";

            // when
            Car car = new Car(carName);

            // then
            assertThat(car.getName()).isEqualTo(carName);
        }

        @DisplayName("자동차 전진횟수가 같으면 성공한다. (1)")
        @Test
        void testCar2() {
            // given
            String carName = "name";
            Car car = new Car(carName);

            // when
            car.increaseMoveCount();

            // then
            assertThat(car.getMoveCount()).isEqualTo(1);
        }

        @DisplayName("자동차 전진횟수가 같으면 성공한다. (2)")
        @Test
        void testCar3() {
            // given
            String carName = "name";
            Car car = new Car(carName);
            car.increaseMoveCount();

            // when
            boolean matches = car.hasMoveCount(1);

            // then
            assertThat(matches).isTrue();
        }
    }

    @DisplayName("실패 테스트를 검증한다.")
    @Nested
    class EdgeCase {

        @DisplayName("자동차 이름의 길이가 5를 넘으면 실패한다.")
        @Test
        void testCar1() {
            // given
            String carName = "invalid_name";

            // when & then
            assertThatThrownBy(() -> new Car(carName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH.getDescription());
        }

        @DisplayName("자동차가 전진횟수가 다르면 실패한다. (1)")
        @Test
        void testCar2() {
            // given
            String carName = "name";
            Car car = new Car(carName);

            // when
            car.increaseMoveCount();

            // then
            assertThat(car.getMoveCount()).isNotEqualTo(2);
        }

        @DisplayName("자동차가 전진횟수가 다르면 실패한다. (2)")
        @Test
        void testCar3() {
            // given
            String carName = "name";
            Car car = new Car(carName);
            car.increaseMoveCount();

            // when
            boolean matches = car.hasMoveCount(2);

            // then
            assertThat(matches).isFalse();
        }
    }
}