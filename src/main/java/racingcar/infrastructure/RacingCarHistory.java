package racingcar.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class RacingCarHistory {
    private final Map<Long, List<Car>> racingCarHistory;

    public RacingCarHistory() {
        this.racingCarHistory = new HashMap<>();
    }

    //라운드별 경기결과 저장
    public void addRound(long round, List<Car> cars) {
        racingCarHistory.put(round, List.copyOf(cars));
    }

    // 라운드별 자동차 상태 조회
    public List<Car> getCars(Long round) {
        return new ArrayList<>(racingCarHistory.getOrDefault(round, new ArrayList<>()));
    }

    public int getSize() {
        return racingCarHistory.size();
    }

}
