package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceHistory;
import racingcar.domain.RaceRound;

class HistoryServiceTest {

    private HistoryService historyService;

    @BeforeEach
    void init() {
        historyService = new HistoryService();
    }

    @Test
    @DisplayName("횟수별 자동차가 전진한 기록을 저장")
    void recordRound() {
        for (int i = 0; i < 5; i++) {
            List<Car> cars = carList(new int[]{-1 + i, 2 + i, 3 + i}, "pobi", "woni", "jun");
            historyService.recordRound(cars);
        }
        RaceHistory history = historyService.getHistory();

        List<RaceRound> rounds = history.getRounds();

        assertThat(rounds).hasSize(5);
        assertThat(rounds.getFirst().getCarPositions().keySet()).isEqualTo(Set.of("pobi", "woni", "jun"));
        assertThat(rounds.getLast().getCarPositions().values()).containsExactly("---", "-------", "------");
        assertThat(rounds.get(2).getCarPositions().values()).containsExactly("-", "-----", "----");
    }

    public List<Car> carList(int[] count , String... names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i< names.length;i++){
            cars.add(createCarWithResults(names[i], count[i]));
        }
        return cars;
    }

    private Car createCarWithResults(String name, int resultCount) {
        Car car = new Car(name);
        for (int i = 0; i < resultCount; i++) {
            car.addResult();
        }
        return car;
    }

}