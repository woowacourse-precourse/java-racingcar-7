package racingcar.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.MoveStrategy;

public class RaceResultTest {

    private MoveStrategy alwaysMoveStrategy;

    @BeforeEach
    void setUp() {
        this.alwaysMoveStrategy = new AlwaysMoveStrategy();
    }

    @Test
    void 우승한_자동차_테스트() {
        Cars cars = new Cars("pobi", alwaysMoveStrategy);
        RaceResult raceResult = new RaceResult(cars);

        cars.moveAllCars();
        List<String> winners = raceResult.getWinners();

        assertThat(winners).isEqualTo(List.of("pobi"));
        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    void 우승한_자동차_여러_대_테스트() {
        Cars cars = new Cars("pobi,woni,jun", alwaysMoveStrategy);
        RaceResult raceResult = new RaceResult(cars);

        cars.moveAllCars();
        List<String> winners = raceResult.getWinners();

        assertThat(winners).isEqualTo(List.of("pobi", "woni", "jun"));
        assertThat(winners.size()).isEqualTo(3);
    }

}
