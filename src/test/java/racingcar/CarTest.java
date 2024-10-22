package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    @Test
    void createCar() {
        String case1 = "pobi,woni,jun";
        String case2 = "pobi";

        List<Car> cars1 = Car.generateCars(case1);
        List<Car> cars2 = Car.generateCars(case2);

        Assertions.assertAll(
                () -> assertEquals(3, cars1.size()),
                () -> assertEquals(1, cars2.size())
        );
    }
  
}