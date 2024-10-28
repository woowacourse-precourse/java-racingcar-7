package racingcar.domain.race.service;

import racingcar.application.dto.response.RaceResponse;
import racingcar.domain.race.constants.RaceFormat;

public class RaceFormatter {

    public static String format(RaceResponse response) {
        return RaceFormat.RACE_RESULT.generate(response.raceResult()) +
            RaceFormat.FINAL_WINNER.generate(response.winners());
    }
}
