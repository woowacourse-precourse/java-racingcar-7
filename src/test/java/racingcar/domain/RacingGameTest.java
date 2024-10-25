package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Condition;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.round.RoundResult;

class RacingGameTest {

    @Test
    @DisplayName("아직 시작되지 않은 게임에서 결과 조회 시 예외가 발생한다.")
    void givenNewGame_whenGetRacingResult_thenThrowsException() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(0, 0), 1);

        // when & then
        assertThatThrownBy(racingGame::getRacingResult).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2라운드 게임에서 1라운드 진행 후에는 게임이 끝나지 않는다.")
    void givenTwoRoundGame_whenPlayOneRound_thenGameIsNotOver() {
        // given
        RacingGame game = new RacingGame(createTwoCar(0, 0), 2);

        // when
        game.playNextRound();

        // then
        assertThat(game.isNotGameOver()).isTrue();
    }

    @Test
    @DisplayName("2라운드 게임에서 2번째 라운드 진행 후 게임이 종료된다.")
    void givenTwoRoundGame_whenCompleteTwoRounds_thenGameIsOver() {
        // given
        List<Car> cars = List.of(new Car("car1", new Condition(new RandomNumberGenerator())));
        RacingGame racingGame = new RacingGame(cars, 2);
        racingGame.playNextRound();

        // when
        racingGame.playNextRound();

        // then
        assertThat(racingGame.isNotGameOver()).isFalse();
    }

    @Test
    @DisplayName("자동차들의 이동 결과가 예상한 결과와 일치한다.")
    void givenCarsWithPredictableMovement_whenPlayRound_thenResultsMatch() {
        // given
        // 0 - 움직임, 9 - 움직이지 않음
        RacingGame racingGame = new RacingGame(createTwoCar(0, 9), 1);
        racingGame.playNextRound();

        // when
        List<RoundResult> result = racingGame.getRacingResult();

        // then
        List<RoundResult> expected = List.of(new RoundResult("car1", 0), new RoundResult("car2", 1));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 종료 후, 우승자가 정확히 결정된다")
    void givenCompletedGame_whenGetWinners_thenReturnsCorrectWinners() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(0, 9), 1);
        racingGame.playNextRound();

        // when
        List<String> result = racingGame.getFinalWinners();

        // then
        List<String> expected = List.of("car2");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 종료 후, 여러명의 우승자를 반환한다.")
    void givenAllCarsAdvanced_whenGetWinners_thenReturnsAllCars() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(9, 9), 1);
        racingGame.playNextRound();

        // when
        List<String> result = racingGame.getFinalWinners();

        // then
        List<String> expected = List.of("car1", "car2");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("모두 다 이동하지 못할 경우에도 우승자가 여러명이다.")
    void givenNoCarsAdvanced_whenGetWinners_thenReturnsAllCars() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(0, 0), 1);
        racingGame.playNextRound();

        // when
        List<String> result = racingGame.getFinalWinners();

        // then
        List<String> expected = List.of("car1", "car2");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("시작되지 않은 게임에서, 우승자를 조회 시 예외가 발생한다.")
    void givenNewGame_whenGetWinners_thenThrowsException() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(0, 0), 1);

        // when & then
        assertThatThrownBy(racingGame::getFinalWinners)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최종 라운드가 아닐 때, 우승자를 조회 시 예외가 발생한다.")
    void givenOnGoingGame_whenGetWinners_thenThrowsException() {
        // given
        RacingGame racingGame = new RacingGame(createTwoCar(0, 0), 2);
        racingGame.playNextRound();

        // when & then
        assertThatThrownBy(racingGame::getFinalWinners)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Car> createTwoCar(int movement1, int movement2) {
        return List.of(
                new Car("car1", new Condition(() -> movement1)),
                new Car("car2", new Condition(() -> movement2))
        );
    }

}