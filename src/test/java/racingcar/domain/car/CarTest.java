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

    @Test
    void 자동차_이동() {
        String carName = "test";
        IntSupplier intSupplier = () -> 4;
        Car car = Car.of(carName, intSupplier);

        car.move();

        Assertions.assertEquals(car.getPosition(), 1);
    }

    @Test
    void 자동차_이동_2() {
        String carName = "test";
        IntSupplier intSupplier = () -> 4;
        Car car = Car.of(carName, intSupplier);

        car.move();
        car.move();

        Assertions.assertEquals(car.getPosition(), 2);
    }

    @Test
    void 자동차_이동_안함() {
        String carName = "test";
        IntSupplier intSupplier = () -> 3;
        Car car = Car.of(carName, intSupplier);

        car.move();

        Assertions.assertEquals(car.getPosition(), 0);
    }
}