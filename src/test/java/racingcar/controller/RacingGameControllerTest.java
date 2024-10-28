package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        racingGameService = new RacingGameService();
    }

    @Test
    void 라운드별_자동차_위치_출력_테스트() {
        String carNamesInput = "pobi,woni,jun";
        List<Car> cars = racingGameService.createCars(carNamesInput);

        cars.forEach(Car::move);

        OutputView.printRoundResult(cars);

        String expectedOutput = String.format("pobi : -%n" + "woni : -%n" + "jun : -%n%n");
        assertThat(outputStreamCaptor.toString()).isEqualTo(expectedOutput);
    }
}
