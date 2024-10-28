package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_생성_빈문자열_이름_유효성_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_생성_초과길이_이름_유효성_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("invalidName"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    car.randomMove();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    car.randomMove();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void 자동차_위치_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    car.randomMove();
                    String positionDisplay = car.displayPosition();
                    assertThat(positionDisplay).isEqualTo("pobi : -");
                },
                MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
