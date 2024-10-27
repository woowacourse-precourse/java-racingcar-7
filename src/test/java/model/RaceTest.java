package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {

    private Race race;
    private MoveStrategy neverMoveStrategy;

    @BeforeEach
    void setUp() {
        MoveStrategy alwaysMoveStrategy = () -> true;  // 항상 이동하는 전략
        neverMoveStrategy = () -> false; // 이동하지 않는 전략
        race = new Race(List.of("Car1", "Car2", "Car3"), 5, alwaysMoveStrategy);
    }

    @Test
    @DisplayName("시도 횟수만큼 전체 경주가 정상적으로 수행되는지 확인")
    void startRace_withCallback() {
        List<List<Integer>> raceStatuses = new ArrayList<>();

        // 콜백을 통해 매 시도마다 각 차량의 위치를 복사하여 저장
        race.startRace(cars -> {
            List<Integer> positions = new ArrayList<>();
            for (Car car : cars) {
                positions.add(car.getPosition()); // 위치를 복사하여 저장
            }
            raceStatuses.add(positions);
        });

        assertEquals(5, raceStatuses.size(), "시도 횟수와 동일한 상태 업데이트가 이루어져야 합니다.");

        for (int i = 0; i < raceStatuses.size(); i++) {
            int expectedPosition = i + 1; // 각 시도마다 위치가 증가
            for (Integer position : raceStatuses.get(i)) {
                assertEquals(expectedPosition, position, "각 시도 후 모든 차의 위치가 올바르게 증가해야 합니다.");
            }
        }
    }


    @Test
    @DisplayName("단일 시도가 경주에 참여한 모든 차량에 대해 잘 동작하는지 확인")
    void attemptOnce() {
        race.attemptOnce(); // 한 번의 시도 수행
        for (Car car : race.getCars()) {
            assertEquals(1, car.getPosition(), "차량이 한 번의 이동 후 위치가 1이어야 합니다.");
        }
    }

    @Test
    @DisplayName("우승자를 올바르게 결정하는지 확인")
    void getWinners() {
        // 이동 불가 전략으로 경주 생성
        Race nonMovingRace = new Race(List.of("Car1", "Car2", "Car3"), 5, neverMoveStrategy);
        nonMovingRace.startRace(null);

        List<String> winners = nonMovingRace.getWinners();
        assertEquals(3, winners.size(), "모든 차량이 동일한 위치일 때 모두가 우승자가 되어야 합니다.");
        assertTrue(winners.containsAll(List.of("Car1", "Car2", "Car3")), "우승자는 모든 차량이어야 합니다.");
    }

    @Test
    @DisplayName("가장 높은 위치에 있는 우승자의 위치를 정확히 계산하는지 확인")
    void getWinnerPosition() {
        race.startRace(null); // 이동 가능한 전략으로 전체 경주 수행
        int winnerPosition = race.getWinnerPosition();
        assertEquals(5, winnerPosition, "모든 차량이 최대 위치에 도달했을 때 우승자의 위치는 시도 횟수와 동일해야 합니다.");
    }
}
