package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomMoveStrategyTest {

    private final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

    @Test
    @DisplayName("RandomMoveStrategy가 이동 가능 여부를 잘 반환하는지 테스트")
    void testRandomMoveProbability() {
        int moveCount = 0;
        int noMoveCount = 0;

        // 100번의 테스트로 이동 가능/불가능 확률을 확인
        for (int i = 0; i < 1000; i++) {
            if (randomMoveStrategy.canMove()) {
                moveCount++;
            } else {
                noMoveCount++;
            }
        }

        // 일정 확률 내에서 이동 가능 여부가 분포하는지 확인
        System.out.println("Move count: " + moveCount);
        System.out.println("No move count: " + noMoveCount);

        assertTrue(moveCount > 0, "이동 가능한 경우가 최소 한 번 이상 발생해야 합니다.");
        assertTrue(noMoveCount > 0, "이동 불가능한 경우가 최소 한 번 이상 발생해야 합니다.");
    }
}
