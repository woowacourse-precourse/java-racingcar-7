package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("Car 객체는 이름과 이동거리 0으로 초기화되어야 한다.")
    void car_객체_초기화_이름_이동거리_0() {
        Car car = new Car("bmw");
        assertThat(car.getName()).isEqualTo("bmw");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car는 반드시 랜덤값이 4 이상인 경우에만 이동해야 한다.")
    void 랜덥값_4이상_입력시에는_이동() {
        Car car = new Car("Audi");
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car는 반드시 랜덤값이 4 이하인 경우에는 움직일 수 없다.")
    void 랜덥값_4이하_입력시에는_멈춤() {
        Car car = new Car("Sonata");
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }


}
