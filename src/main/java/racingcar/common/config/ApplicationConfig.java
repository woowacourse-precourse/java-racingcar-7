package racingcar.common.config;

import racingcar.controller.RaceController;
import racingcar.common.filter.RaceExecutionFilter;
import racingcar.common.filter.RaceFilterChain;
import racingcar.common.filter.RaceInputValidationFilter;
import racingcar.common.filter.RaceWinnerDecisionFilter;
import racingcar.common.filter.RacingCarListParsingFilter;
import racingcar.common.filter.executor.RaceExecutor;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;

public class ApplicationConfig {
    private final RaceFilterChain raceFilterChain;

    public ApplicationConfig() {
        this.raceFilterChain = createRaceFilterChain();
    }

    private RaceFilterChain createRaceFilterChain() {
        return RaceFilterChain.builder()
                .addFilter(new RaceInputValidationFilter())
                .addFilter(new RacingCarListParsingFilter())
                .addFilter(new RaceExecutionFilter(new RaceExecutor()))
                .addFilter(new RaceWinnerDecisionFilter())
                .build();
    }

    public RaceService getRaceService() {
        return new RaceServiceImpl(raceFilterChain);
    }


    public RaceController getRaceController() {
        return new RaceController(getRaceService());
    }
}
