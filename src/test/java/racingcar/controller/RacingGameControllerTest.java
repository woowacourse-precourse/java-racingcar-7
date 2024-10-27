package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    private InputView inputView;
    private OutputView outputView;
    private RacingGameController racingGameController;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        outputView = new OutputView();
        racingGameController = new RacingGameController(inputView, outputView);
    }

    @Test
    void 자동차_설정_테스트() {
        List<String> inputNames = Arrays.asList("pobi", "java");

        List<Car> cars = racingGameController.setCars(inputNames);

        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("java");
    }
}

