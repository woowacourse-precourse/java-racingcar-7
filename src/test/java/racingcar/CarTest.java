package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 생성 성공")
    @Test
    void carTest() {
        String carName = "pobi";

        Car car = new Car(carName);

        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }
}
