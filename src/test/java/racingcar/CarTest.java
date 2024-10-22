package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    @Test
    void createCar_success() {
        //given
        String case1 = "pobi,woni,jun";
        String case2 = "pobi";

        //when
        List<Car> cars1 = Car.generateCars(case1);
        List<Car> cars2 = Car.generateCars(case2);

        //then
        Assertions.assertAll(
                () -> assertEquals(3, cars1.size()),
                () -> assertEquals(1, cars2.size())
        );
    }
    @Test
    void createCar_exception() {
        //given
        String case1 = "hello";
        String case2 = "helloWorld";

        //when // then
        Assertions.assertAll(
                () -> assertEquals(1, Car.generateCars(case1).size()),
                () -> assertThrows(IllegalArgumentException.class, () -> Car.generateCars(case2))
        );
    }
}