package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Movement;

public class CarTest {

    private final Movement movableMovement = () -> true;
    private final Movement notMovableMovement = () -> false;

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
        Car car = new Car("hwan");

        car.move(movableMovement.canMove());

        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_위치를_비교할_수_있다() {
        Car one = new Car("hwan");
        Car another = new Car("leo");

        one.move(movableMovement.canMove());

        assertTrue(one.isFartherThan(another));
    }
}
