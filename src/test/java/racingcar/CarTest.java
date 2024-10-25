package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.Car.Car;
import racingcar.Car.CarName;
import racingcar.Car.Position;

public class CarTest {

    @Test
    void testCarCreationWithValidName() {

        //when & given
        Car car = new Car(new CarName("pobi"));

        //then
        assertThat(car.getName().getValue()).isEqualTo("pobi");
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    void testCarCreationWithInvalidName() {

        //when & then
        assertThatThrownBy(() -> new Car(new CarName("")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(new CarName("cheche903")))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void testCarMovement() {

        //given
        Car car = new Car(new CarName("pobi"));

        //when
        car.moveForward();
        Position position = car.getPosition();

        //then
        assertThat(position.getValue()).isGreaterThanOrEqualTo(0);
    }

}
