package racingcar.domain.history.repository;

import racingcar.domain.history.RacingHistory;

import java.util.List;

public interface RacingHistoryRepository {
    void saveRacingHistory(RacingHistory racingHistory);

    List<RacingHistory> getRacingHistory();
}
