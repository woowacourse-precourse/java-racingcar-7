package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void testCreateCars() {
        String carNames = "pobi, crong, honux";
        int tryTimes = 5;

        List<Car> cars = carService.createCars(carNames, tryTimes);

        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("crong", cars.get(1).getName());
        assertEquals("honux", cars.get(2).getName());

        for (Car car : cars) {
            assertEquals(tryTimes, car.getReportCard().size());
        }
    }

}
