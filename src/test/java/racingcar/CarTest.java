package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름을_출력() {
        racingcar.car.Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}