package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void testCarCreationWithValidName() {

        // given & When
        Car car = new Car("pobi");

        // Then
        assertThat(car.carName).isEqualTo("pobi");
        assertThat(car.position).isEqualTo(0);
    }

    @Test
    void testCarCreationWithInvalidName() {

        // when & then
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car("wonikim"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCarMovement() {

        // given
        Car car = new Car("pobi");

        // when
        car.moveFoward();
        int position = car.position;

        // then
        assertThat(position).isGreaterThanOrEqualTo(0);
    }
}
