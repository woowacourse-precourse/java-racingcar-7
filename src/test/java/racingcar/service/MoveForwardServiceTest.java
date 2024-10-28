package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveForwardRecord;

class MoveForwardServiceTest {

    private MoveForwardService moveForwardService;

    @BeforeEach
    void setting() {
        moveForwardService = new MoveForwardService();
    }

    @DisplayName("전진횟수 0으로 초기화 했는지 확인")
    @Test
    void 전진횟수_초기화() {

        moveForwardService.setMoveForwardRecord(List.of("car1"));
        List<MoveForwardRecord> moveForwardRecords = moveForwardService.getMoveForwardRecords();

        assertEquals(moveForwardRecords.get(0).getCarName(), "car1");
        assertEquals(moveForwardRecords.get(0).getGoCount(), 0);
    }

    @DisplayName("4 이상일때만 전진")
    @Test
    void 숫자가_4이상만_전진() {
        moveForwardService.setMoveForwardRecord(List.of("car1", "car2"));

        MoveForwardRecord canMoveForward = moveForwardService.getMoveForwardRecords().get(0);
        canMoveForward.updateGoCount(3);
        assertEquals(canMoveForward.getGoCount(), 0);

        MoveForwardRecord canNotMoveForward = moveForwardService.getMoveForwardRecords().get(0);
        canMoveForward.updateGoCount(4);
        assertEquals(canMoveForward.getGoCount(), 1);

    }
}