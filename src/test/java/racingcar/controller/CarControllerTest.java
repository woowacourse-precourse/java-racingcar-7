package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarControllerTest {

    private CarController carController;
    private InputView inputView;
    private OutputView outputView;
    private CarService carService;

    @BeforeEach
    public void setUp() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
        this.carController = new CarController(outputView, inputView, carService);
    }

    @Test
    @DisplayName("자동차 게임을 시작할 수 있다.")
    public void 자동차_게암_시작_테스트() {
        // given
        List<String> expectedCarNames = List.of("CarA", "CarB", "CarC");

        // when
        System.setIn(new ByteArrayInputStream("CarA,CarB,CarC\n3\n".getBytes()));
        carController.run();

        // then
        assertEquals(expectedCarNames, carService.getParticipantsName());

        int finalPosition = carService.getParticipants().get(0).getDistance();
        assertTrue(finalPosition >= 0);
    }

}
