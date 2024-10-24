package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "pobi,crong", "pobi"})
    @DisplayName("자동차 경주 게임을 실행한다.")
    void run(String names) {
        RacingGameController racingGameController = new RacingGameController(new RacingGame(() -> 4));
        String result = racingGameController.run(CarFactory.createCars(names, 4, 5), "5");
        Assertions.assertThat(result).isEqualTo(names);
    }

}