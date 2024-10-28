package racingcar.domain.racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        RacingGame racingGame = new RacingGame(cars);

        //when
        Map<String, Integer> result = racingGame.getDistances();

        //then
        List<Integer> valueList = result.values()
                                .stream()
                                .toList();
        assertThat(valueList).isEqualTo(new ArrayList<>(Arrays.asList(1, 1, 1)));
    }

    @Test
    void getFormattedGameResult() {
    }
}