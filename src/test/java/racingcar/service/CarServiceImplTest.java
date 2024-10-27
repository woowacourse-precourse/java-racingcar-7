package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;

class CarServiceImplTest {
    private CarRepository carRepository;
    private CarService carService;

    @BeforeEach
    void setUp() {
        carRepository = new CarMemoryRepository();
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    void 등록() throws Exception {
        // given
        String carName = "현대";
        // when
        carService.register(carName);
        // then
        assertEquals(1, carRepository.getNumberOfCars());
    }

    @Test
    void 등록_예외() throws Exception {
        // given
        List<String> carNames = Arrays.asList("", "abcdef", "가나다라마바사", "123456");
        // when
        for (String carName : carNames) {
            assertThrows(IllegalArgumentException.class, () -> carService.register(carName));
        }
    }
}