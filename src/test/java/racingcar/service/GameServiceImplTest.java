package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;

class GameServiceImplTest {

    private CarRepository carRepository;

    private GameService gameService;

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carRepository = new CarMemoryRepository();
        gameService = new GameServiceImpl(carRepository);
    }

    private void initCarData() {
        carNames = Arrays.asList("Java", "Scala", "Rust", "Swish");
        for (String name : carNames) {
            Car car = new Car(new CarName(name));
            carRepository.save(car);
        }
    }

    @Test
    void 무작위_차량이동() throws Exception {
        // given
        initCarData();
        // when
        gameService.moveCarsRandomly();
        // then
        int afterPositionSum = carRepository.findAll().stream().mapToInt(Car::getPosition).sum();
        assertTrue(afterPositionSum >= 0);
    }
    
}