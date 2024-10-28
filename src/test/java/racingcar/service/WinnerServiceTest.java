package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveForwardRecord;

class WinnerServiceTest {

    private WinnerService winnerService;

    @BeforeEach
    void setting() {
        winnerService = new WinnerService();
    }

    @DisplayName("전진횟수 내림차순으로 정렬")
    @Test
    void 전진횟수_내림차순_정렬() {
        List<MoveForwardRecord> moveForwardRecords = new ArrayList<>(List.of(new MoveForwardRecord("car1", 1),
                new MoveForwardRecord("car2", 3), new MoveForwardRecord("car3", 2)));

        winnerService.countSortReverse(moveForwardRecords);

        assertEquals(moveForwardRecords.get(0).getCarName(), "car2");
        assertEquals(moveForwardRecords.get(1).getCarName(), "car3");
        assertEquals(moveForwardRecords.get(2).getCarName(), "car1");
    }

    @DisplayName("우승 차 선별")
    @Test
    void 우승_차_선별() {
        List<MoveForwardRecord> moveForwardRecords = new ArrayList<>(List.of(new MoveForwardRecord("car1", 1),
                new MoveForwardRecord("car2", 2), new MoveForwardRecord("car3", 3)));

        winnerService.countSortReverse(moveForwardRecords);
        List<String> winners = winnerService.getWinners(moveForwardRecords);

        assertEquals(winners.get(0),"car3");
    }

}