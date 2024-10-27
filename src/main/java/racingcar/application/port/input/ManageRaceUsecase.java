package racingcar.application.port.input;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.domain.race.Race;

public interface ManageRaceUsecase {

    RaceResponse run(RaceRequest raceRequest);

    String determineWinners(Race race);
}
