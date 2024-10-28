package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar");
    }

    @Test
    void 이름_반환_테스트() {
        assertThat(car.getName()).isEqualTo("TestCar");
    }

    @Test
    void 현재_거리_반환() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 거리_수정_테스트() {
        car.setDistance(10);
        assertThat(car.getDistance()).isEqualTo(10);
    }
}