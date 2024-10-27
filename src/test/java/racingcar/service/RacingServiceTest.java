package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRacingGame;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class RacingServiceTest {

    @Test
    @DisplayName("자동차 경주 게임 시작")
    void carRacingGameStart() {
        // given
        RacingService racingService = new RacingService();
        List<Car> carList = List.of(Car.create("pobi"), Car.create("woni"), Car.create("javaji"));
        CarRacingGame carRacingGame = CarRacingGame.createRacingGame(5, carList);

        // when
        racingService.carRacingGameStart(carRacingGame);

        // then
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getPosition()).isNotEqualTo(0);
        }

    }
}