package racingcar.application.service.history;

import racingcar.domain.car.RacingCar;
import racingcar.domain.history.RacingHistory;
import racingcar.infrastructure.persistence.InMemoryRacingHistoryRepository;

public class RacingHistoryService {
    private final InMemoryRacingHistoryRepository historyRepository;

    public RacingHistoryService() {
        this.historyRepository = InMemoryRacingHistoryRepository.getInstance();
    }

    // TODO : 실행결과 저장하기
    public void saveHistory(RacingCar racingCar) {
        historyRepository.saveRacingHistory(new RacingHistory(racingCar.getName(), racingCar.getDistance()));
    }

    // TODO : 최대 거리 갱신하기

    // TODO : 실행결과 출력하기
}
