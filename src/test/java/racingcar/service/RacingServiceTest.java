package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;


class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        racingService = new RacingService(inputView, outputView);
    }

    @Test
    @DisplayName("자동차 이름으로 객체 생성")
    void addRacingCar() {
        String inputCarNames = "pobi,woni,jun";
        racingService.addRacingCar(inputCarNames);
        assertThat(racingService.getRacingCars()).hasSize(3).containsKeys("pobi", "woni", "jun");

    }

    @Test
    void playGame() {
        String inputCarNames = "pobi,woni";
        racingService.addRacingCar(inputCarNames);

        int rounds = 3;
        racingService.playGame(rounds);

        Map<String, RacingCar> cars = racingService.getRacingCars();
        assertThat(cars.get("pobi").getScore()).isNotNegative();
        assertThat(cars.get("woni").getScore()).isNotNegative();
    }
}