package racingcar.application.port.inbound;

import racingcar.application.dto.RacingGameRequest;
import racingcar.application.dto.Response;

public interface GameUseCase {
    Response execute(RacingGameRequest request);
}
