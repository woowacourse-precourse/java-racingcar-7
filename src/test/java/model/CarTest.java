package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이름_받기_테스트() {
        Car car1 = new Car("kng");
        assertThat(car1.getName()).contains("kng");
    }

    @Test
    void 진행정도_받기_테스트() {
        Car car1 = new Car("kng");
        assertThat(car1.getStep()).isEqualTo(0);
    }

    @Test
    void 자동차_움직이기_테스트() {
        Car car1 = new Car("kng");
        car1.randomMove();
        assertThat(car1.getStep()).isBetween(0, 1);
    }

}