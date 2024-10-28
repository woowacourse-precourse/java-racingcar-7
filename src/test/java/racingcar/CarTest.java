package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.RacingCar;

/**
 * class: CarTest.
 *
 * @author JBumLee
 * @version 2024/10/28
 */
@DisplayName("Car 클래스 테스트")
class CarTest {
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @Test
    void createCarWithLongName() {
        assertThatThrownBy(() -> RacingCar.create("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 하며, 빈 값일 수 없습니다.");
    }

    @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
    @Test
    void createCarWithEmptyName() {
        assertThatThrownBy(() -> RacingCar.create(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 하며, 빈 값일 수 없습니다.");
    }

    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    @Test
    void createCarWithNullName() {
        assertThatThrownBy(() -> RacingCar.create(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 하며, 빈 값일 수 없습니다.");
    }

    @DisplayName("자동차가 정상적으로 생성된다")
    @Test
    void createCarSuccess() {
        Car car = RacingCar.create("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 위치가 변화하는지 확인")
    @RepeatedTest(100)
    void moveTest() {
        Car car = RacingCar.create("pobi");
        int initialPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isIn(initialPosition, initialPosition + 1);
    }
}