package service;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        // 항상 이동하는 MoveStrategy 익명 클래스를 사용하여 RaceService 생성
        MoveStrategy alwaysMoveStrategy = () -> {
            return true; // 모든 시도에서 이동하도록 설정
        };
        raceService = new RaceService(List.of("Car1", "Car2", "Car3"), 5, alwaysMoveStrategy);
    }

    @Test
    @DisplayName("Race가 정상적으로 시도 횟수만큼 수행되는지 확인")
    void startRace_withCallback() {
        // 경주 상태를 저장하기 위한 리스트
        List<List<Car>> raceStatuses = new ArrayList<>();

        // 콜백으로 각 시도 후의 상태를 수집하는 RaceStatusCallback 구현체
        RaceStatusCallback callback = cars -> {
            List<Car> carsCopy = new ArrayList<>();
            for (Car car : cars) {
                carsCopy.add(new Car(car.getName(), car.getPosition())); // 각 차량을 복사하여 저장
            }
            raceStatuses.add(carsCopy);
        };

        // 경주 시작
        raceService.startRace(callback);

        assertEquals(5, raceStatuses.size(), "시도 횟수와 동일한 상태 업데이트가 이루어져야 합니다.");

        for (int i = 0; i < raceStatuses.size(); i++) {
            int expectedPosition = i + 1; // 각 시도마다 위치가 증가
            for (Car car : raceStatuses.get(i)) {
                assertEquals(expectedPosition, car.getPosition(), "각 시도 후 모든 차의 위치가 올바르게 증가해야 합니다.");
            }
        }
    }

    @Test
    @DisplayName("우승자가 정확히 계산되는지 확인")
    void getWinners() {
        // 콜백 없이 경주를 수행
        raceService.startRace(null);

        List<String> winners = raceService.getWinners();
        assertEquals(3, winners.size(), "모든 차량이 동일한 위치일 때 모두가 우승자가 되어야 합니다.");
        assertEquals(List.of("Car1", "Car2", "Car3"), winners, "우승자는 모든 차량이어야 합니다.");
    }
}
