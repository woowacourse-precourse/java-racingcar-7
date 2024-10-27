package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.domain.RacingHistory;

public class InMemoryRacingHistoryRepository implements RacingHistoryRepository {
    /* 키 : 라운드 숫자, 값 : 그 라운드에 기록된 RacingHistory */
    private final Map<Integer, List<RacingHistory>> historyMap = new HashMap<>();
    private static final InMemoryRacingHistoryRepository INSTANCE = new InMemoryRacingHistoryRepository();

    private InMemoryRacingHistoryRepository() {

    }

    public static InMemoryRacingHistoryRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(RacingHistory racingHistory) {
        int roundNumber = racingHistory.getRoundNumber();
        historyMap.computeIfAbsent(roundNumber, k -> new ArrayList<>()).add(racingHistory);
    }

    @Override
    public List<RacingHistory> findByRoundNumber(int roundNumber) {
        return new ArrayList<>(historyMap.getOrDefault(roundNumber, new ArrayList<>()));
    }
}
