package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.dto.RoundResultDto;
import racingcar.wrapper.RaceCount;

public class RaceServiceTest {

    private RaceService raceService;
    private Cars cars;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        String carNames = "pobi,crong,honux";
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();
        cars = new Cars(carNames, moveStrategy);
    }

    @Test
    void 라운드_결과_리스트로_반환_테스트() {
        List<RoundResultDto> roundResults = raceService.playRace(cars, RaceCount.of("5"));

        assertThat(roundResults.size())
                .isEqualTo(5);
    }

}
