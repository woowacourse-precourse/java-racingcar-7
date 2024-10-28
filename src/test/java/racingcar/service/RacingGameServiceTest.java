package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.racinggame.RacingGames;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;
import racingcar.dto.ResultDTO;

class RacingGameServiceTest {
    @Test
    public void testRunGame() {
        // Arrange: 필요한 DTO 생성
        RacingCarNamesDTO namesDTO = new RacingCarNamesDTO("Car1,Car2,Car3");
        RacingAttemptDTO attemptsDTO = new RacingAttemptDTO("3");

        // Act: runGame 호출
        ResultDTO result = RacingGameService.runGame(namesDTO, attemptsDTO);

        // Assert: 예상 결과 확인
        assertNotNull(result.getGameResult());
        assertFalse(result.getGameResult().isEmpty());
        assertNotNull(result.getFinalWinner());
        assertFalse(result.getFinalWinner().isEmpty());
    }

    @Test
    void printPlayingResult() {
        //given
        RacingCarNamesDTO racingCarNamesDTO = new RacingCarNamesDTO("Car1,Car2,Car3");
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isAllowedToAdvance() {
                return true;
            }
        };
        Cars cars = new Cars(racingCarNamesDTO, moveStrategy);
        RacingGame racingGame = new RacingGame(cars);
        RacingGames racingGames = new RacingGames();
        racingGames.addRacingGame(racingGame);

        //when
        String result = RacingGameService.printPlayingResult(racingGames);

        //then
        assertThat(result).isEqualTo("Car1 : -\nCar2 : -\nCar3 : -\n\n");
    }

    @Test
    void 최종우승자_자동차_출력_테스트() {
        //given
        RacingCarNamesDTO racingCarNamesDTO = new RacingCarNamesDTO("Car1,Car2,Car3");
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isAllowedToAdvance() {
                return true;
            }
        };
        Cars cars = new Cars(racingCarNamesDTO, moveStrategy);

        //when
        String winners = RacingGameService.getMaxDistanceCars(cars);

        //then
        assertThat(winners).isEqualTo("Car1, Car2, Car3");
    }
}