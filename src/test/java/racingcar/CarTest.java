package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이름이 5글자를 초과하는 경우 예외를 반환하는 걸 테스트하라")
    @Test
    void test1() {
        assertThatThrownBy(() -> new Car("다섯글자가넘는차"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 null 이거나 빈 경우 예외를 반환하는 걸 테스트하라")
    @ParameterizedTest
    @NullAndEmptySource
    void test2(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차가 전진하는 경우 포지션이 1증가하는 것을 테스트하라")
    @Test
    void test3() {
        Car car1 = new Car("car1");

        int distance1 = car1.go(() -> true);
        int distance2 = car1.go(() -> true);
        int distance3 = car1.go(() -> true);

        assertThat(distance1).isEqualTo(1);
        assertThat(distance2).isEqualTo(2);
        assertThat(distance3).isEqualTo(3);
    }

    @DisplayName("차가 정지하는 경우 포지션이 그대로인 것을 테스트하라")
    @Test
    void test4() {
        Car car1 = new Car("car1");

        int distance1 = car1.go(() -> false);
        int distance2 = car1.go(() -> false);
        int distance3 = car1.go(() -> false);

        assertThat(distance1).isEqualTo(0);
        assertThat(distance2).isEqualTo(0);
        assertThat(distance3).isEqualTo(0);
    }
}
