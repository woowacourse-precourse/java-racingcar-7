package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameRule;
import racingcar.domain.RacingGame;

class GameServiceTest {

    private GameService gameService;
    private RacingGame racingGame;

    @BeforeEach
    void createGame() {
        gameService = new GameService();
        Car car1 = gameService.createCar("car1");
        Car car2 = gameService.createCar("car2");
        racingGame = new RacingGame(List.of(car1, car2), new GameRule(1));
    }

    @DisplayName("전진조건을 만족하면 차가 앞으로 한칸 이동한다")
    @Test
    void carMoveWhenRuleMet() {

        int randomNumber = 5;
        racingGame.getCars()
                .forEach(car -> gameService.checkRuleStopOrMove(racingGame, car, randomNumber));

        racingGame.getCars()
                .forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }

    @DisplayName("전진조건을 만족하지 않으면 차가 정지한다")
    @Test
    void carNotMoveWhenRuleNotMet() {
        int randomNumber = 3;

        racingGame.getCars()
                .forEach(car -> gameService.checkRuleStopOrMove(racingGame, car, randomNumber));

        racingGame.getCars()
                .forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }
}