package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이동거리_증가() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = Car.of("pobi");
                    car.move();
                    car.move();
                    assertThat(car.toString()).isEqualTo("pobi : --");
                }, MOVING_FORWARD, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = Car.of("woni");
                    car.move();
                    car.move();
                    car.move();
                    assertThat(car.toString()).isEqualTo("woni : -");
                }, STOP, STOP, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = Car.of("jun");
                    car.move();
                    car.move();
                    car.move();
                    car.move();
                    assertThat(car.toString()).isEqualTo("jun : ---");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );

    }

    @Test
    void 이름_길이_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.of("pobiiii"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하의 문자열만 가능합니다.");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.of("pobi,javajigi"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하의 문자열만 가능합니다.");
        });
    }

    @Test
    void 빈_이름_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.of(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
        assertSimpleTest(() -> {
            (assertThatThrownBy(() -> Car.of("  "))
                    .isInstanceOf(IllegalArgumentException.class))
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.of(" \n\n "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
    }
}
