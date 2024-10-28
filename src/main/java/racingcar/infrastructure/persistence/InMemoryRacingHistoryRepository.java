package racingcar.infrastructure.persistence;

import racingcar.domain.history.RacingHistory;
import racingcar.domain.history.repository.RacingHistoryRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRacingHistoryRepository implements RacingHistoryRepository {
    private static final InMemoryRacingHistoryRepository instance = new InMemoryRacingHistoryRepository();
    private final List<RacingHistory> racingHistorys;
    private int maxDistance = 0;

    private InMemoryRacingHistoryRepository() {
        this.racingHistorys = new ArrayList<>();
    }

    public static InMemoryRacingHistoryRepository getInstance(){
        return instance;
    }

    public void saveRacingHistory(RacingHistory racingHistory) {
        updateMaxDistance(racingHistory);
        racingHistorys.add(racingHistory);
    }

    private void updateMaxDistance(RacingHistory racingHistory){
        maxDistance = Math.max(racingHistory.getDistance(),maxDistance);
    }

    public List<RacingHistory> getRacingHistory() {
        return racingHistorys;
    }

    public int getMaxDistance(){
        return this.maxDistance;
    }
}
