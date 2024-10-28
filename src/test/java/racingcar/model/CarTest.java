package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
