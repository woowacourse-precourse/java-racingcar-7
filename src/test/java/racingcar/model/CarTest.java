package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Car인스턴스 생성 시점에 winningPoint는 0점이다")
    void whenConstructCarWinningPointZero() {
        //given //when
        Car car = new Car("pobi");

        //then
        assertThat(car.getPoint()).isZero();
    }

    @Test
    @DisplayName("자동차가 3번 전진하면 winningPoint는 3이어야한다")
    void validCarWinningPoint() {
        //given
        Car car = new Car("pobi");

        //when
        car.move();
        car.move();
        car.move();

        //then
        assertThat(car.getPoint()).isSameAs(3);
    }
}