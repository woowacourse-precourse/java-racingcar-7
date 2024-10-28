package racingcar.model;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름_5자_초과_예외_테스트() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름_빈문자열_예외_테스트() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("pobi");

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(1); // 전진했으므로 position이 1
                },
                MOVING_FORWARD // 전진 조건을 만족하는 값 (4 이상)
        );
    }

    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("pobi");

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(0); // 멈췄으므로 position이 그대로
                },
                STOP // 전진 조건을 만족하지 않는 값 (4 미만)
        );
    }
}