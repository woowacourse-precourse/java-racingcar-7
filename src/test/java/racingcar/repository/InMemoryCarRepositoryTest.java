package racingcar.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import racingcar.config.AppConfig;
import racingcar.model.Car;
import org.junit.jupiter.api.Test;

class InMemoryCarRepositoryTest {
    AppConfig appConfig = AppConfig.getInstance();

    @DisplayName("자동차 저장")
    @Test
    void save() {
        CarRepository carRepository = appConfig.getCarRepository();
        String carName = "붕붕이";

        Car car = new Car(carName);
        carRepository.save(car);

        assertEquals(carRepository.findAll().get(0).getName(), carName);
        assertEquals(carRepository.findAll().get(0).getProgress(), 0);
    }
}