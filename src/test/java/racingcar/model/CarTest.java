package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void carForward() {
        Car car = new Car("pobi");
        car.move(MOVING_FORWARD);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void carStop() {
        Car car = new Car("pobi");
        car.move(STOP);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void displayStateTest() {
        Car car = new Car("pobi");
        car.move(MOVING_FORWARD);

        String state = car.displayState();

        assertThat(state).isEqualTo("pobi : -");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "javaji"})
    public void validateNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
