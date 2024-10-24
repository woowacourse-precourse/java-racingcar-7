package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 전진_1회_테스트() throws Exception {
        //given
        Car car = new Car("test car");
        //when
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    car.goAndStop();
                    assertThat(car.getForwardCount()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    public void 전진_3회_테스트() throws Exception {
        //given
        Car car = new Car("test car");
        //when
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 4; i++) {
                        car.goAndStop();
                    }
                    assertThat(car.getForwardCount()).isEqualTo(3);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}