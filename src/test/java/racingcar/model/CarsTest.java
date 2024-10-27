package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(new Car("CarA"), new Car("CarB"), new Car("CarC")));
    }

    @Test
    @DisplayName("가장 먼 위치에 있는 자동차가 우승자임")
    void testGetWinners() {
        cars.getCarList().get(0).move();
        cars.getCarList().get(1).move();

        List<Car> winners = cars.getWinners();
        int maxPosition = cars.getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        for (Car winner : winners) {
            assertEquals(maxPosition, winner.getPosition());
        }
    }
}