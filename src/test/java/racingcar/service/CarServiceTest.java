package racingcar.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarServiceTest {

    private CarRepository carRepository;
    private CarService carService;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryImpl();
        carService = new CarService(carRepository);
    }

    @AfterEach
    void tearDown() {
        // 테스트 후 데이터 초기화
        carRepository.findAll().clear();
    }

    @Test
    void 자동차_등록_성공() {
        Car car = new Car("Swn");
        carService.joinCar(car);

        List<Car> cars = carRepository.findAll();
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getName()).isEqualTo("Swn");
    }

    @Test
    void 자동차_중복_이름_등록_실패() {
        Car car1 = new Car("Swn");
        Car car2 = new Car("Swn");

        carService.joinCar(car1);
        assertThatThrownBy(() -> carService.joinCar(car2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 회원 존재");
    }

    @Test
    void 자동차_전진() {

        Car car1 = new Car("Swn");
        Car car2 = new Car("Bae");

        carService.joinCar(car1);
        carService.joinCar(car2);

        assertRandomNumberInRangeTest(
                () -> {
                    carService.moveCar();

                    List<Car> cars = carService.getAllCars();
                    List<String> names = cars.stream().map(Car::getName).toList();
                    List<Integer> counts = cars.stream().map(Car::getCount).toList();

                    assertThat(names).containsExactly("Swn", "Bae");
                    assertThat(counts.get(0)).isEqualTo(1);
                    assertThat(counts.get(1)).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );

    }

    @Test
    void 우승자_찾기() {
        Car car1 = new Car("Swn");
        Car car2 = new Car("Bae");

        carService.joinCar(car1);
        carService.joinCar(car2);

        assertRandomNumberInRangeTest(
                () -> {
                    carService.moveCar();

                    List<String> winners = carService.findWinners();

                    // 우승자 이름 리스트를 검증
                    assertThat(winners).containsExactly("Swn");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_찾기() {
        Car car1 = new Car("Swn");
        Car car2 = new Car("Bae");

        carService.joinCar(car1);
        carService.joinCar(car2);

        assertRandomNumberInRangeTest(
                () -> {
                    carService.moveCar();

                    List<String> winners = carService.findWinners();

                    // 우승자 이름 리스트를 검증
                    assertThat(winners).containsExactlyInAnyOrder("Swn", "Bae");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
