package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void testCarCreationWithValidName() {

        // given & When
        Car car = new Car(new Name("pobi"));

        // Then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
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
        int position = car.getPosition();

        // then
        assertThat(position).isGreaterThanOrEqualTo(0);
    }
}
