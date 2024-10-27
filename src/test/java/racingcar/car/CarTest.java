package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private final String carName = "testCar";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(carName);
    }

    @Test
    void 자동차가_정상적으로_생성된다() {
        // then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가_정상적으로_이동한다() {
        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
