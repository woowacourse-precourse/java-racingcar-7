package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveOrStop() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            car.moveOrStop();
            assertThat(car.getDistance()).isEqualTo(1);
        }, 4, 3);

    }
}