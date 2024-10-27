package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class CarTest {

    Car car = new Car("pobi");

    @Test
    void 이름_설정_확인() {
        assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    void 초기_거리_확인() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 호출에_따라_거리_증가() {
        int initialDistance = car.getDistance();

        for (int i = 0; i < 10; i++) {
            car.move();
        }

        assertThat(car.getDistance()).isGreaterThanOrEqualTo(initialDistance);
    }
}