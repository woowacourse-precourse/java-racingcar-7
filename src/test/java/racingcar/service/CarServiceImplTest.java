package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.repository.CarRepository;

class CarServiceImplTest {
    CarRepositoryMock carRepository;
    CarServiceImpl carService;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryMock();
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    void 자동차_이름_저장_기능_테스트() {
        //given
        List<String> carNameList = List.of("pobi", "woni", "jun");

        //when
        carService.createCarsFromNameList(carNameList);

        //then
        assertThat(List.of("pobi", "woni", "jun"))
                .isEqualTo(carRepository.getSavedCarNames());
    }

    @Test
    void 자동차_이름_예외_테스트() {
        //given
        List<String> carNameList = List.of("pobi", "woni", "hoyoung");

        //when,then
        assertThatThrownBy(
                () -> carService.createCarsFromNameList(carNameList)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 자동차_움직인_거리_저장_기능_테스트() {
        //given
        List<String> carNameList = List.of("pobi", "woni", "jun");

        //when
        carService.createCarsFromNameList(carNameList);

        //then
        assertThat(0)
                .isEqualTo(carRepository.getMovedDistances().stream().mapToInt(Integer::intValue).sum());
    }

    static class CarRepositoryMock implements CarRepository {
        private final List<Car> savedCars = new ArrayList<>();

        @Override
        public void save(Car car) {
            savedCars.add(car);
        }

        @Override
        public List<Car> findAll() {
            return new ArrayList<>(savedCars);
        }

        @Override
        public void updateAll(List<Car> carList) {
            this.savedCars.clear();
            this.savedCars.addAll(carList);
        }

        public List<String> getSavedCarNames() {
            List<String> carNames = new ArrayList<>();
            for (Car car : savedCars) {
                carNames.add(car.getName());
            }
            return carNames;
        }

        public List<Integer> getMovedDistances() {
            List<Integer> carMovedDistances = new ArrayList<>();
            for (Car car : savedCars) {
                carMovedDistances.add(car.getMovedDistance());
            }
            return carMovedDistances;
        }
    }
}
