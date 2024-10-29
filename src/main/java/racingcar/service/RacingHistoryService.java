package racingcar.service;

import java.util.List;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;

public interface RacingHistoryService {
    List<RacingHistoryOutputDto> findHistoryByRound(int roundNumber);
}
