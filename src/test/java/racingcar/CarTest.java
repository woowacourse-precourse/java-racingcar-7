package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성자_테스트() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.dashCount).isEqualTo(0);
    }

    @Test
    void move_메소드_테스트() {
        Car car = new Car("pobi");

        car.move();

        assertThat(car.dashCount).isEqualTo(1);
    }

    @Test
    void stop_메소드_테스트() {
        Car car = new Car("pobi");

        car.move();  // 대시 수를 1로 증가시킨다.
        car.stop();

        assertThat(car.dashCount).isEqualTo(1); // 대시 수는 변하지 않아야한다.
    }

    @Test
    void moveDashCount_메소드_테스트() {
        Car car = new Car("pobi");

        int result = car.moveDashCount();

        assertThat(result).isEqualTo(1); // 첫 이동 시 대시 수는 1
    }

    @Test
    void stopDashCount_메소드_테스트() {
        Car car = new Car("pobi");

        car.move(); // 대시 수를 1로 증가시킵니다.
        int result = car.stopDashCount();

        assertThat(result).isEqualTo(1); // 대시 수는 여전히 1
    }
}
