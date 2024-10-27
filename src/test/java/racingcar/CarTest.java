package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 위치가 음수인 경우 예외를 반환하는 걸 테스트하라")
    @Test
    void test() {
        int position = -1;
        assertThatThrownBy(() -> new Car("test", position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 position 은 음수일 수 없습니다. 현재 포지션: (%d)", position));
    }

    @DisplayName("자동차의 이름이 5글자를 초과하는 경우 예외를 반환하는 걸 테스트하라")
    @Test
    void test1() {
        String name = "다섯글자가넘는차";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 쉼표(,)를 기준으로 5글자이하로만 가능합니다. 입력된 이름: (%s)", name));
    }

    @DisplayName("자동차의 이름이 null 이거나 빈 경우 예외를 반환하는 걸 테스트하라")
    @ParameterizedTest
    @NullAndEmptySource
    void test2(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 null 이거나 빈 칸일 수 없습니다. 입력된 이름: (%s)", name));
    }

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
