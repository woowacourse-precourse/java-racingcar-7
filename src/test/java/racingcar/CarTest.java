package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이동거리_증가() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi");
            car.increaseDistance();
            assertThat(car.toString()).isEqualTo("pobi : -");
        });

        assertSimpleTest(() -> {
            Car car = new Car("woni");
            car.increaseDistance();
            car.increaseDistance();
            assertThat(car.toString()).isEqualTo("woni : --");
        });
    }
}
