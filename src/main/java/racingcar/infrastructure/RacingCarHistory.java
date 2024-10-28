package racingcar.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Vehicle;

public class RacingCarHistory implements RacingHistory{
    private final Map<Long, List<Vehicle>> racingCarHistory;

    public RacingCarHistory() {
        this.racingCarHistory = new HashMap<>();
    }

    //라운드별 경기결과 저장
    @Override
    public void addRound(long round, List<Vehicle> cars) {
        racingCarHistory.put(round, List.copyOf(cars));
    }

    // 라운드별 자동차 상태 조회
    @Override
    public List<Vehicle> getCars(Long round) {
        return new ArrayList<>(racingCarHistory.getOrDefault(round, new ArrayList<>()));
    }
    @Override
    public int getSize() {
        return racingCarHistory.size();
    }

}
