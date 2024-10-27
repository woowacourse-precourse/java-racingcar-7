package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRacingGame;
import racingcar.service.RacingService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerAggregaterTest {

    @Test
    @DisplayName("게임이 끝난 후 우승자를 반환")
    void getWinner() {
        // given
        WinnerAggregater winnerAggregater = new WinnerAggregater();
        RacingService racingService = new RacingService();

        List<Car> carList = List.of(Car.create("pobi"), Car.create("woni"), Car.create("javaji"));

        CarRacingGame carRacingGame = CarRacingGame.createRacingGame(5, carList);
        racingService.carRacingGameStart(carRacingGame);

        // when
        String winner = winnerAggregater.getWinner(carList);

        // then
        assertThat(winner).containsAnyOf("pobi", "woni", "javaji");
    }
}