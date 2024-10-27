package racingcar.application.port.inbound;

import racingcar.application.dto.RacingGameRequest;

public interface GameUseCase {
    void execute(RacingGameRequest request);
}
