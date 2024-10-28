package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @Test
    void 차는_한_칸씩_움직인다() {
        //given
        Car car = new Car("hi");

        //when
        car.move();
        int actual = car.getPosition();

        //then
        int expect = 1;
        assertThat(actual).isEqualTo(expect);
    }
}