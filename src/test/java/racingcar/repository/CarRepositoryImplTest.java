package racingcar.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryImplTest {

    private CarRepositoryImpl carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        carRepository.clear(); // clear() 메서드 추가 필요
    }

    @Test
    void 자동차_저장_테스트() {
        Car car = new Car("Swn");

        // 자동차 저장 후 확인
        Car savedCar = carRepository.save(car);
        assertThat(savedCar).isEqualTo(car);

        // 저장된 자동차가 리스트에 포함되었는지 확인
        assertThat(carRepository.findAll()).contains(car);
    }

    @Test
    void 자동차_이름으로_찾기_테스트() {
        Car car1 = new Car("Swn");
        Car car2 = new Car("Bae");
        carRepository.save(car1);
        carRepository.save(car2);

        // 이름으로 자동차 찾기
        Optional<Car> foundCar = carRepository.findByName("Swn");
        assertThat(foundCar).isPresent().contains(car1);

        // 없는 이름 검색 시 빈 Optional 반환
        Optional<Car> notFoundCar = carRepository.findByName("nick");
        assertThat(notFoundCar).isEmpty();
    }

    @Test
    void 모든_자동차_반환_테스트() {
        Car car1 = new Car("Swn");
        Car car2 = new Car("Bae");
        carRepository.save(car1);
        carRepository.save(car2);

        // 모든 자동차 반환 확인
        List<Car> cars = carRepository.findAll();
        assertThat(cars).containsExactly(car1, car2);
    }
}
