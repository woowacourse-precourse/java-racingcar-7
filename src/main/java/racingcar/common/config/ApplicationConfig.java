package racingcar.common.config;

import racingcar.controller.RaceController;
import racingcar.filter.CarListParsingFilter;
import racingcar.filter.RaceExecutionFilter;
import racingcar.filter.RaceFilterChain;
import racingcar.filter.RaceInputValidationFilter;
import racingcar.filter.RaceWinnerDecisionFilter;
import racingcar.filter.executor.RaceExecutor;
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
                .addFilter(new CarListParsingFilter())
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
