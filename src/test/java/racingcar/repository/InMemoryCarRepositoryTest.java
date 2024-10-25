package racingcar.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import racingcar.model.Car;
import org.junit.jupiter.api.Test;

class InMemoryCarRepositoryTest {

    @DisplayName("자동차 저장")
    @Test
    void save() {
        CarRepository carRepository = new InMemoryCarRepository();
        String carName = "붕붕이";

        Car car = new Car(carName);
        carRepository.save(car);

        assertEquals(carRepository.findAll().get(0).name(), carName);
        assertEquals(carRepository.findAll().get(0).progress(), 0);
    }
}