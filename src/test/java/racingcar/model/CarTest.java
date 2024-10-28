package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 자동차를 전진한다")
    void testMove1() {
        // given
        Car car = new Car("TestCar");

        // when
        assertRandomNumberInRangeTest(car::move, 5);

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 4 미만일 경우 자동차는 전진하지 않는다. ")
    void testMove2() {
        //given
        Car car = new Car("TestCar");

        // when
        assertRandomNumberInRangeTest(car::move, 2);

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }
}