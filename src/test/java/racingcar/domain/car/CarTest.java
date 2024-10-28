package racingcar.domain.car;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

class CarTest {


    @Test
    void 자동차_생성() {
        String carName = "test";
        IntSupplier intSupplier = () -> 1;

        Car car = Car.of(carName, intSupplier);

        Assertions.assertEquals(car.getCarName(), carName);
    }

    @Test
    void 자동차_생성_실패() {
        String carName = "";
        IntSupplier intSupplier = () -> 1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> Car.of(carName, intSupplier));
    }
}