package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차의 이름과 초기 전진 횟수 확인")
    void createCar_checkNameAndForwardCount() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getForwardCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 전진할 때 전진 횟수가 1 증가하는지 확인")
    void moveForward_increaseCount() {
        Car car = new Car("pobi");
        car.moveOneStep();
        assertThat(car.getForwardCount()).isEqualTo(1);
    }
}