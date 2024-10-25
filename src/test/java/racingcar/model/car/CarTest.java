package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 전진 함수와 출력함수가 작동하는지 확인한다")
    void 자동차_전진_상태_출력_테스트() {
        Car car = new Car("pobi");
        car.goForward();
        car.goForward();
        assertThat(car.toString()).isEqualTo("pobi : --");
    }
}