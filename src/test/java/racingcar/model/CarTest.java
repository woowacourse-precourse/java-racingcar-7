package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_이름으로_객체_생성() {
        String name = "pobi";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차가_전진_시_위치가_증가한다() {
        Car car = new Car("pobi");

        car.move(true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_정지_시_위치가_변하지_않는다() {
        Car car = new Car("pobi");

        car.move(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
