package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이동_횟수_확인() {
        Car car = new Car("test");
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }

}