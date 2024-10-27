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

    @Test
    void 테스트_3_2_toString_확인() {
        Car car = new Car("a");
        car.goForward();
        car.goForward();

        assertThat(car.toString()).isEqualTo("a : --");
    }
}