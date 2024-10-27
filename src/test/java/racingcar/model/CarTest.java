package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차는_이름을_가질_수_있다() {
        String input = "hwan";

        Car car = new Car(input);
        String carName = car.getName();

        assertEquals(carName, input);
    }

    @Test
    void 자동차의_이름은_5자_이하여야_한다() {
        String input = "hwanvely";

        assertThatIllegalArgumentException().isThrownBy(() -> new Car(input));
    }

    @Test
    void 자동차는_전진할_수_있다() {
        boolean canMove = true;
        Car car = new Car("hwan");

        car.move(canMove);

        assertEquals(1, car.getPosition());
    }
}
