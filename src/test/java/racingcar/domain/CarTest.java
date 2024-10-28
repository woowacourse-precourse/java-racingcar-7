package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Movable 상태일 때 move 메서드가 distance를 증가시키는지 확인")
    void move_WhenMovable_IncreasesDistance() {
        // given
        Car car = new Car("car1", new FixedRandomGenerator(5));

        // when
        int initialDistance = car.getDistance();
        car.move();

        // then
        assertThat(car.getDistance()).isGreaterThan(initialDistance);
    }

    @Test
    @DisplayName("Movable 상태가 아닐 때 move 메서드가 distance를 유지하는지 확인")
    void move_WhenNotMovable_DoesNotIncreaseDistance() {
        // given
        Car car = new Car("car1", new FixedRandomGenerator(3));

        // when
        int initialDistance = car.getDistance();
        car.move();

        // then
        assertThat(car.getDistance()).isEqualTo(initialDistance);
    }

    @Test
    @DisplayName("getName 메서드가 Car 이름을 반환하는지 확인")
    void getName_ReturnsCarName() {
        // given
        Car car = new Car("car1", new FixedRandomGenerator(5));

        // when & then
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("toString 메서드가 올바른 Car 상태 표현을 반환하는지 확인")
    void toString_ReturnsCarRepresentation() {
        // given
        Car car = new Car("car1", new FixedRandomGenerator(5));

        // when
        car.move();

        // then
        assertThat(car.toString()).isEqualTo("car1 : -");
    }
}
