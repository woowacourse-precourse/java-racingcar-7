package racingcar.repository;

import java.util.List;
import racingcar.model.domain.RacingHistory;

public interface RacingHistoryRepository {
    void save(RacingHistory racingHistory);

    List<RacingHistory> findByRoundNumber(int roundNumber);
}
