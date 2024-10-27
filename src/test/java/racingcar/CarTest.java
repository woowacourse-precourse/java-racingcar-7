package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void testCarCreationWithValidName() {

        // given & When
        Car car = new Car(new Name("pobi"));

        // Then
        assertThat(car.name.getName()).isEqualTo("pobi");
        assertThat(car.position).isEqualTo(0);
    }

    @Test
    void testCarCreationWithInvalidName() {

        // when & then
        assertThatThrownBy(() -> new Car(new Name("")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(new Name("cheche903")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCarMovement() {

        // given
        Car car = new Car(new Name("pobi"));

        // when
        car.moveForward();
        int position = car.position;

        // then
        assertThat(position).isGreaterThanOrEqualTo(0);
    }
}
