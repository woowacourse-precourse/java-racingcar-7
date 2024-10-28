package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest extends NsTest {

    @Test
    void 자동차_진행상황_출력테스트() {
        //given
        Car car = new Car();
        car.nameCar("car1");

        //when
        car.forward();
        car.forward();
        car.printForwardLevel();

        //then
        assertThat(output()).contains("car1 : --");
    }

    @Override
    protected void runMain() {

    }
}
