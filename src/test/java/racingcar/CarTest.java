package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차가 전진하는 경우 포지션이 1증가하는 것을 테스트하라")
    @Test
    void test3() {
        Car car1 = new Car("car1");

        car1.move(() -> true);
        car1.move(() -> true);
        car1.move(() -> true);

        assertThat(car1.getPosition()).isEqualTo(PositionFixture.position(3));
    }

    @DisplayName("차가 정지하는 경우 포지션이 그대로인 것을 테스트하라")
    @Test
    void test4() {
        Car car1 = new Car("car1");

        car1.move(() -> false);
        car1.move(() -> false);
        car1.move(() -> false);

        assertThat(car1.getPosition()).isEqualTo(PositionFixture.position(0));
    }

    @DisplayName("차가 2번 전진, 1번 정지하는 경우 포지션이 2인 것을 테스트하라")
    @Test
    void test5() {
        Car car1 = new Car("car1");

        car1.move(() -> true);
        car1.move(() -> true);

        car1.move(() -> false);

        assertThat(car1.getPosition()).isEqualTo(PositionFixture.position(2));
    }

    @DisplayName("차가 1번 전진, 2번 정지하는 경우 포지션이 1인 것을 테스트하라")
    @Test
    void test6() {
        Car car1 = new Car("car1");

        car1.move(() -> true);

        car1.move(() -> false);
        car1.move(() -> false);

        assertThat(car1.getPosition()).isEqualTo(PositionFixture.position(1));
    }
}
