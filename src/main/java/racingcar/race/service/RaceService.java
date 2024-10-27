package racingcar.race.service;

import java.util.regex.Pattern;
import racingcar.global.constants.CarConstants;
import racingcar.global.constants.RaceConstants;
import racingcar.race.dto.RaceRequest;

public class RaceService {
    public int enterRaceNumber() {
        RaceRequest raceRequest = new RaceRequest();
        String round = raceRequest.enterRaceNumbetInteger();
        roundIntegerValidation(round);
        return Integer.parseInt(round);
    }

    private void roundIntegerValidation(String roundNumber) {
        if (!Pattern.matches(RaceConstants.RACE_ROUND_INT_VALIDATION, roundNumber)) {
            throw new IllegalArgumentException(RaceConstants.RACE_ROUND_ERROR_MESSAGE);
        }
    }
}
