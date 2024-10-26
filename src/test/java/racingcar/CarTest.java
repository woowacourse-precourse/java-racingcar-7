package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차가 전진하면, 전진 횟수가 1 증가한다.")
    void 전진_테스트() {
        //given
        Car car = Car.create("yumi");
        //when
        car.movingForward();
        car.movingForward();
        //then
        Assertions.assertThat(car.getForwardNumber()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차가 정지하면, 전진 횟수는 변화가 없다.")
    void 정지_테스트() {
        //given
        Car car = Car.create("yumi");
        //when
        car.stop();
        //then
        Assertions.assertThat(car.getForwardNumber()).isEqualTo(0);
    }
}