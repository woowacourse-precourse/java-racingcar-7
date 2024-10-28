package racingcar.application.port.input;

import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;

public interface ManageRaceUsecase {

    RaceResponse run(RaceRequest raceRequest);
}
