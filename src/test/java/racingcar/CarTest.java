package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 테스트_3_1_goForward_확인() {
        Car car = new Car("a");
        int beforeDistance = car.getDistance();
        car.goForward();
        int afterDistance = car.getDistance();

        assertThat(afterDistance - beforeDistance).isEqualTo(1);
    }
}