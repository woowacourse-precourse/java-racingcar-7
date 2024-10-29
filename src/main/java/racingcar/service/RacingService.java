package racingcar.service;

import java.util.List;
import racingcar.dto.CarDto;

public interface RacingService {
    void startRacing(int attemptCount);

    List<CarDto.CarOutputDto> selectWinner();
}
