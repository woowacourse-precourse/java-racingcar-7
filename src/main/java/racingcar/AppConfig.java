package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.RaceRule;
import racingcar.service.RaceService;
import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.generator.RandomDigitsGenerator;

public class AppConfig {
    public RaceController raceController() {
        return new RaceController(raceService());
    }

    public RaceService raceService() {
        return new RaceService(raceRule());
    }

    public RaceRule raceRule() {
        return new RaceRule(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomDigitsGenerator();
    }
}