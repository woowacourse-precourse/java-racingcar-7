package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void createCarWithValidName() {
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
        assertThat(car.getWinCount()).isZero();
    }

    @Test
    void increasePosition() {
        car.increasePosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void increaseWinCount() {
        car.increaseWinCount();
        assertThat(car.getWinCount()).isEqualTo(1);
    }

    @Test
    void resetPosition() {
        car.increasePosition();
        car.setZeroPosition();
        assertThat(car.getPosition()).isZero();
    }


}
