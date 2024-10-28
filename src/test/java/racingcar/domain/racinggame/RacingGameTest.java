package racingcar.domain.racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.dto.RacingCarNamesDTO;

class RacingGameTest {

    @Test
    void 거리를_제대로_저장하는지_확인() {
        //given
        RacingCarNamesDTO racingCarNamesDTO = new RacingCarNamesDTO("Car1,Car2,Car3");
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isAllowedToAdvance() {
                return true;
            }
        };
        Cars cars = new Cars(racingCarNamesDTO, moveStrategy);
        RacingGame racingGame = new RacingGame();

        //when
        racingGame.startGame(cars);
        List<Integer> result = racingGame.getDistances();

        //then
        assertThat(result).isEqualTo(new ArrayList<>(Arrays.asList(1, 1, 1)));
    }

    @Test
    void getDistances() {
    }

    @Test
    void getFormattedGameResult() {
    }
}