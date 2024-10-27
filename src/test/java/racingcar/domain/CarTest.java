package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름이 빈칸이나 5글자를 초과할 수 없다.")
    @Test
    void 자동차_이름_길이_에러() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 4이상인 경우 전진할 수 있다.")
    @Test
    public void 전진_하는지() {
        Car car = new Car("pobi");
        car.moveCar(4);
        assertThat(car.getDistanceValue()).isEqualTo(1);
    }

    @DisplayName("숫자가 3이하인 경우 전진할 수 없다.")
    @Test
    public void 전진_안하는지() {
        Car car = new Car("pobi");
        car.moveCar(1);
        assertThat(car.getDistanceValue()).isEqualTo(0);
    }

}
