package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.TestNumberGenerator;

class CarRepositoryTest {
    private final Car pobiCar = new Car("pobi");
    private final Car woniCar = new Car("woni");
    private final Car junCar = new Car("jun");
    private final List<Car> newCars = new ArrayList<>(Arrays.asList(pobiCar, woniCar, junCar));

    private CarRepository carRepository;
    private TestNumberGenerator testNumberGenerator;

    @BeforeEach
    void setUp() {
        testNumberGenerator = new TestNumberGenerator(4);
        carRepository = new CarRepository(testNumberGenerator);
    }

    @Test
    @DisplayName("자동차 리스트 저장을 정상적으로 한다")
    void saveTest() {
        assertThat(carRepository.getCurrentCars()).hasSize(0);
        carRepository.saveAll(newCars);
        assertThat(carRepository.getCurrentCars()).hasSize(3);
    }

    @Test
    @DisplayName("모든 자동차가 전진을 한다.")
    void moveAllTest() {
        carRepository.saveAll(newCars);
        carRepository.getCurrentCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
        carRepository.attemptMoveAllCars();
        carRepository.getCurrentCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }

    @Test
    @DisplayName("모든 자동차가 전진을 하지 않는다.")
    void notMoveAllTest() {
        testNumberGenerator = new TestNumberGenerator(3);
        carRepository = new CarRepository(testNumberGenerator);
        carRepository.saveAll(newCars);
        carRepository.getCurrentCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
        carRepository.attemptMoveAllCars();
        carRepository.getCurrentCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

    @Test
    @DisplayName("자동차 리스트 복사본이 현재 객채와 값은 같지만 참조는 다른 상태으로 반환한다")
    void getCurrentCarsCopyTest() {
        carRepository.saveAll(newCars);
        List<Car> copiedCars = carRepository.getCurrentCars();

        // 객체안에 필드 값은 같지만, 참조 값은 다름
        for (int i = 0; i < copiedCars.size(); i++) {
            assertThat(copiedCars.get(i))
                    .usingRecursiveComparison()
                    .isEqualTo(newCars.get(i))
                    .isNotSameAs(newCars.get(i));
        }

        // 복사본을 움직였지만 기존 자동차는 상태는 변하지 않음
        copiedCars.get(0).move();
        assertThat(copiedCars.get(0).getPosition()).isEqualTo(1);
        assertThat(newCars.get(0).getPosition()).isEqualTo(0);
    }
}
