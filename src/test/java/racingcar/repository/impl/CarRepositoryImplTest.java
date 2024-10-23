package racingcar.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

class CarRepositoryImplTest {
    CarRepository carRepository = new CarRepositoryImpl();

    @Test
    void findAll() {
        // given
        List<String> carNames = List.of("pobi", "woni");
        List<Car> cars = carNames.stream().map(Car::new).toList();

        for(Car car : cars) {
            carRepository.save(car);
        }

        // when
        List<Car> car = carRepository.findAll();
        List<String> carObjNames = car.stream().map(Car::getName).toList();

        // then
        assertThat(carObjNames).containsExactly("pobi", "woni");
    }

    @Test
    void findByName() {
        // given
        List<String> carNames = List.of("pobi", "woni");
        List<Car> cars = carNames.stream().map(Car::new).toList();

        for(Car car : cars) {
            carRepository.save(car);
        }

        // when
        Car car = carRepository.findByName("woni");

        // then
        assertThat(car.getName()).isEqualTo("woni");
    }
}