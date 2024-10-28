package racingcar.domain.racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.dto.RacingCarNamesDTO;

class RacingGamesTest {

    @Test
    void 레이싱게임이_잘입력되는지_테스트() {
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

        //when
        racingGames.addRacingGame(racingGame);

        //then
        assertThat(racingGames.getRacingGames()).contains(racingGame);
    }
}