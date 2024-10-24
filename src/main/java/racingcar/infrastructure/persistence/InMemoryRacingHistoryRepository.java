package racingcar.infrastructure.persistence;

import racingcar.domain.history.RacingHistory;
import racingcar.domain.history.repository.RacingHistoryRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRacingHistoryRepository implements RacingHistoryRepository {

    private final List<RacingHistory> racingHistorys;

    public InMemoryRacingHistoryRepository() {
        this.racingHistorys = new ArrayList<>();
    }

    // TODO : 레이싱 결과 저장
    public void saveRacingHistory(RacingHistory racingHistory) {

    }

    // TODO : 레이싱 결과 반환
    public List<RacingHistory> getRacingHistory() {
        return null;
    }
}
