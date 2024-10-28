package racingcar;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void testCarMove(){
        Car car = new Car("TestCar");
        car.move(4);
        assertThat(car.getNow()).isEqualTo(1);

        car.move(3);
        assertThat(car.getNow()).isEqualTo(1);

        car.move(5);
        assertThat(car.getNow()).isEqualTo(2);
    }

    @Test
    public void testPrintNow(){
        Car car = new Car("TestCar");
        car.move(4);
        car.move(5);
        car.move(1);
        assertThat(car.printNow()).isEqualTo("TestCar : --");
    }
}
