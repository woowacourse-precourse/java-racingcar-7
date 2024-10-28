package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_테스트() {
        // given
        Car car = new Car("pobi");
        // when
        car.move();
        car.move();
        // then
        assertThat(car.getPosition()).isEqualTo(2); // 위치가 2로 증가
    }

    @Test
    void 무작위_값이_4일_때_이동() {
        // given
        Car car = new Car("pobi");
        // when
        car.tryToMove(4);
        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_3일_때_이동하지_않음() {
        // given
        Car car = new Car("pobi");
        // when
        car.tryToMove(3);
        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
