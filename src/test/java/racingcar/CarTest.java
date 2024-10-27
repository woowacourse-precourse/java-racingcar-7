package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {
    private static final int MOVE_THRESHOLD = 4;
    @Test
    void 자동차_정보_확인_테스트() {
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    void 자동차_이동_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("car1");
                int initDistance = car.getDistance();

                car.move();
                if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
                    assertThat(car.getDistance()).isEqualTo(initDistance + 1);
                }
                else assertThat(car.getDistance()).isEqualTo(initDistance);
            }, MOVE_THRESHOLD - 1);
    }

    @Override
    public void runMain() {
        // 메인 메소드 X
    }
}