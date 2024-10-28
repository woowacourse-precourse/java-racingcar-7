package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void init() {
        car = new Car("woody", 0);
    }

    @Test
    void 랜덤_숫자가_4_이상이면_전진한다() {
        //given
        int expected = 2;

        //when
        car.tryForwardLevelUp(4);
        car.tryForwardLevelUp(5);

        //then
        Assertions.assertThat(car.getForwardLevel()).isEqualTo(expected);
    }

    @Test
    void 랜덤_숫자가_3_이하이면_전진안한다() {
        //given
        int expected = 0;

        //when
        car.tryForwardLevelUp(2);
        car.tryForwardLevelUp(3);

        //then
        Assertions.assertThat(car.getForwardLevel()).isEqualTo(expected);
    }

}