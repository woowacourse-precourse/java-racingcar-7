package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void testCarCreationWithValidName() {

        //when & given
        Car car = new Car("pobi");

        //then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void testCarCreationWithInvalidName() {

        //when & then
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car("cheche903"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void testCarMovement() {

        //given
        Car car = new Car("pobi");

        //when
        car.moveFoward();
        Position position = car.getPosition();

        //then
        assertThat(position.getValue()).isGreaterThanOrEqualTo(0);
    }

}
