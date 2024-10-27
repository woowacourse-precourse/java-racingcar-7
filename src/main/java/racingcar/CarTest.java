package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void shouldIncreaseLengthWhenRadonNumberOverFour() {
        Car car = new Car("alpha");
        assertRandomNumberInRangeTest(() -> {
            car.addDist();
            assertThat(car.getDist().length())
                    .isEqualTo(1);
        }, 4);
    }

    @Test
    void shouldMaintainLengthWhenRadonNumberBelowThree() {
        Car car = new Car("alpha");
        assertRandomNumberInRangeTest(() -> {
            car.addDist();
            assertThat(car.getDist().length())
                    .isEqualTo(0);
        }, 3);
    }

}

