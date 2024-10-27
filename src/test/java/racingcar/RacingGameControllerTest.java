package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.game.RacingGame;
import racingcar.game.RacingGameController;

class RacingGameControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "pobi,crong", "pobi"})
    @DisplayName("자동차 경주 게임을 실행한다.")
    void run(String names) {
        RacingGameController racingGameController = new RacingGameController(new RacingGame(() -> 4));
        String result = racingGameController.run(CarFactory.createCars(names, 4, 5), "5");
        Assertions.assertThat(result).isEqualTo(names);
    }

    @Test
    @DisplayName("Throws exception for invalid round input")
    void throwsExceptionForInvalidRoundInput() {
        RacingGameController racingGameController = new RacingGameController(new RacingGame(() -> 4));
        List<Car> cars = CarFactory.createCars("pobi,crong,honux", 4, 5);
        Assertions.assertThatThrownBy(() -> racingGameController.run(cars, "invalid"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Throws exception for round less than 1")
    void throwsExceptionForRoundLessThanOne() {
        RacingGameController racingGameController = new RacingGameController(new RacingGame(() -> 4));
        List<Car> cars = CarFactory.createCars("pobi,crong,honux", 4, 5);
        Assertions.assertThatThrownBy(() -> racingGameController.run(cars, "0"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("1이상의 숫자를 입력해주세요");
    }
}