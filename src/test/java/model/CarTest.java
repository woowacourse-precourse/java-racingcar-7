package model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름_받기_테스트() {
        Car car1 = new Car("kng");
        assertThat(car1.getName()).contains("kng");
    }

    @Test
    void 진행정도_받기_테스트() {
        Car car1 = new Car("kng");
        assertThat(car1.getStep()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = "kng")
    void 자동차_움직이기_테스트(String name) {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car(name);
                    car1.randomMove();
                    car1.randomMove();
                    car1.randomMove();
                    assertThat(car1.getStep()).isEqualTo(3);

                }, MOVING_FORWARD
        );
    }

}