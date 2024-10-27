package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertSimpleTest(
                () -> {
                    Car car = new Car("name", 2);
                    assertThat(car.name).isEqualTo("name");
                    assertThat(car.position).isEqualTo(2);
                }
        );

    }

    @Test
    void raceTest() {
        Car car = new Car("gamma", 0);
        car.position += 1;
        car.position += 1;

        assertThat(car.position).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
