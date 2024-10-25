package racingcar.application.usecase;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.domain.race.Race;

public interface RaceExecutionUseCase {

    RaceResponse runRace(RaceRequest raceRequest);

    String determineWinners(Race race);
}
