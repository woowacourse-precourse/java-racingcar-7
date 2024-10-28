package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.move.MoveGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void success_Creation() {
        // Given
        String name = "Pobi";

        // When
        Car car = new Car(name);

        // Then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 이동 테스트")
    void success_Move() {
        // Given
        Car car = new Car("Pobi");
        MoveGenerator moveGenerator = () -> true;

        // When
        car.move(moveGenerator);

        // Then
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 이동하지않음")
    void fail_NotMove() {
        // Given
        Car car = new Car("Pobi");
        MoveGenerator moveGenerator = () -> false;

        // When
        car.move(moveGenerator);

        // Then
        assertThat(car.getLocation()).isEqualTo(0);
    }
}