package racingcar.domain.car;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

class CarTest {


    @Test
    void 자동차_생성() {
        String carName = "test";
        IntSupplier intSupplier = () -> 1;

        Car car = Car.of(carName, intSupplier);

        Assertions.assertThat(car.getCarName()).isEqualTo(carName);
    }
}