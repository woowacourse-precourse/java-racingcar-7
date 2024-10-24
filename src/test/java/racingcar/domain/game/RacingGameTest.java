package racingcar.domain.game;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarState;
import racingcar.domain.car.Cars;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String carNames = "car1,car2";
        Cars cars = Cars.of(carNames, () -> true);
        RaceRounds raceRounds = new RaceRounds(3);
        ScoreBoard scoreBoard = ScoreBoard.ofEmpty();
        racingGame = new RacingGame(cars, raceRounds, scoreBoard);
    }

    @Test
    @DisplayName("RacingGame 객체를 통해 게임을 진행하고 올바른 ScoreBoard를 반환한다.")
    void play() {
        ScoreBoard result = racingGame.play();

        assertSoftly(softly -> {
            softly.assertThat(result.roundScoresList()).hasSize(3);
            softly.assertThat(result.winners()).containsExactly("car1", "car2");

            // 각 라운드의 상태 검증
            softly.assertThat(result.roundScoresList().get(0).carStates()).containsExactly(
                    new CarState("car1", 1),
                    new CarState("car2", 1)
            );
            softly.assertThat(result.roundScoresList().get(1).carStates()).containsExactly(
                    new CarState("car1", 2),
                    new CarState("car2", 2)
            );
            softly.assertThat(result.roundScoresList().get(2).carStates()).containsExactly(
                    new CarState("car1", 3),
                    new CarState("car2", 3)
            );
        });
    }
}
