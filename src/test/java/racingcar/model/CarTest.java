package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진하면_주행거리_증가_성공() {
        // given
        Car car = new Car("myCar", 0);

        // when
        car.goForward();

        // then
        assertThat(car.getTotalDistance()).isEqualTo(1);
    }

}