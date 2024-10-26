package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("Car의 메소드들이 정상적으로 작동하는지 확인한다.")
    @Test
    void carMethodTest() {
        String carName = "testCar";
        Car car = new Car(carName);

        assertThat(carName).isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getAdvanceCount());
        assertThat("").isEqualTo(car.makeHyphen());
        car.addAdvanceCount();
        assertThat(1).isEqualTo(car.getAdvanceCount());
        assertThat("-").isEqualTo(car.makeHyphen());
    }


}
