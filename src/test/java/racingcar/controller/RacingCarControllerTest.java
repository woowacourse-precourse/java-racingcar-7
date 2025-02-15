package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRequestDto;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.service.CarService;
import racingcar.service.RacingService;

public class RacingCarControllerTest {

    private RacingCarController racingCarController;
    private RacingService racingService;
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
        racingService = new RacingService();
        racingCarController = new RacingCarController();
    }

    @Test
    void 자동차_경주_통합_테스트() {
        // given
        RacingRequestDto racingRequestDto = new RacingRequestDto("pobi,woni,jun", 5);
        List<Car> cars = carService.validateCarNames(racingRequestDto.getCarNames());
        Racing racing = new Racing();

        String userInput = "pobi,woni,jun\n5\n"; // Simulate the input the program expects
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // when & then
        assertDoesNotThrow(() -> racingCarController.run());
        assertNotNull(cars);
        assertEquals(3, cars.size());
        assertNotNull(racing);
    }
}
