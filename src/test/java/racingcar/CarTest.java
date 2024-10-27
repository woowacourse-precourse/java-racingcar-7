package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class CarTest {

    @Test
    @DisplayName("자동차 생성 시 초기 위치는 0이다")
    void carInitialPosition() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 이름이 정상적으로 저장된다")
    void carName() {
        String name = "test";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

}
