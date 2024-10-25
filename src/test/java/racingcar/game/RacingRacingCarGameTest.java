package racingcar.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;
import racingcar.game.exception.GamePlayersException.MaximumPlayersExceededException;
import racingcar.game.exception.GamePlayersException.MinimumPlayersRequiredException;
import racingcar.game.exception.GameRoundException.MaximumGameRoundExceededException;
import racingcar.game.exception.GameRoundException.MinimumGameRoundRequiredException;

class RacingRacingCarGameTest {

    @Test
    void createRacingCarGame_게임횟수그리고자동차들입력받으면_생성한다(){
        // given
        final int roundCount = 3;

        final RacingCar racingCar1 = RacingCar.create();
        final RacingCar racingCar2 = RacingCar.create();
        final List<RacingCar> racingCars = List.of(racingCar1, racingCar2);

        // expect
        assertThatCode(() -> RacingCarGame.createLoopedRacingCarGame(roundCount, racingCars))
                .doesNotThrowAnyException();
    }
    @Test
    void createRacingCarGame_자동차최대5대초과시_예외처리(){
        // given
        final int roundCount = 3;

        final RacingCar racingCar1 = RacingCar.create();
        final RacingCar racingCar2 = RacingCar.create();
        final RacingCar racingCar3 = RacingCar.create();
        final RacingCar racingCar4 = RacingCar.create();
        final RacingCar racingCar5 = RacingCar.create();
        final RacingCar racingCar6 = RacingCar.create();
        final List<RacingCar> fiveOverRacingCars = List.of(racingCar1, racingCar2, racingCar3, racingCar4, racingCar5,
                racingCar6);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(roundCount, fiveOverRacingCars))
                .isInstanceOf(MaximumPlayersExceededException.class)
                .hasMessage("최대 5명까지 게임 시작 가능합니다.");
    }

    @Test
    void createRacingCarGame_자동차최소2대미만시_예외처리(){
        // given
        final int roundCount = 3;

        final RacingCar racingCar1 = RacingCar.create();
        final List<RacingCar> oneRacingCar = List.of(racingCar1);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(roundCount, oneRacingCar))
                .isInstanceOf(MinimumPlayersRequiredException.class)
                .hasMessage("최소 2명부터 게임 시작 가능합니다.");
    }

    @Test
    void createRacingCarGame_게임횟수1번미만시_예외처리(){
        // given
        final int lessThanGAME_MINIMUM_ROUND = 0;
        final RacingCar racingCar1 = RacingCar.create();
        final RacingCar racingCar2 = RacingCar.create();
        final List<RacingCar> racingCars = List.of(racingCar1, racingCar2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(lessThanGAME_MINIMUM_ROUND, racingCars))
                .isInstanceOf(MinimumGameRoundRequiredException.class)
                .hasMessage("최소 1번부터 게임 시작 가능합니다");
    }

    @Test
    void createRacingCarGame_게임횟수100번초과시_예외처리(){
        // given
        final int overThanGAME_MAXIMUM_ROUND = 101;
        final RacingCar racingCar1 = RacingCar.create();
        final RacingCar racingCar2 = RacingCar.create();
        final List<RacingCar> racingCars = List.of(racingCar1, racingCar2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(overThanGAME_MAXIMUM_ROUND, racingCars))
                .isInstanceOf(MaximumGameRoundExceededException.class)
                .hasMessage("최대 100번까지 게임 시작 가능합니다");
    }



}