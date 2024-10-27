package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.view.InputView;

class InputControllerTest {
    private final InputStream systemIn = System.in;
    private CarRepository carRepository;
    private CarService carService;
    private InputView inputView;
    private InputController inputController;

    @BeforeEach
    void setUp() {
        carRepository = new CarMemoryRepository();
        carService = new CarServiceImpl(carRepository);
        inputView = new InputView();
        inputController = new InputController(carService, inputView);
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void 콘솔_이름_등록() {
        //given
        String userInput = "car1,car2,car3\n";
        provideInput(userInput);

        //when
        inputController.postNames();

        //then
        List<String> carNames = carRepository.findAll().stream().map(Car::getName).toList();
        List<String> expectedCarNames = Arrays.asList("car1", "car2", "car3");
        assertTrue(expectedCarNames.containsAll(carNames));
    }
}