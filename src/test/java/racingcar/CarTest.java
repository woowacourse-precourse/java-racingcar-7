package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import racingcar.model.Car;

class CarTest extends NsTest {
    private Car car;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 초기_거리_테스트() {
        // 자동차 생성 직후 거리 0인지 확인
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 이름_저장_테스트() {
        // 이름이 올바르게 저장되었는지 확인
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 이동_성공_테스트() {
        int startDistance = car.getDistance();

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(startDistance + 1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 이동_실패_테스트() {
        int startDistance = car.getDistance();

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(startDistance);
                },
                STOP
        );
    }

    @Test
    void 공백_제거_테스트() {

    }

    @Override

    public void runMain() {
        Application.main(new String[]{});
    }
}
