package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차의 위치는 0부터 시작한다")
    @Test
    void initCarTest() {
        //given
        Car car = new Car("yj");
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차를 앞으로 한 칸 움직인다.")
    @Test
    void moveTest() {
        //given
        Car car = new Car("yj");
        //when
        car.move();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}