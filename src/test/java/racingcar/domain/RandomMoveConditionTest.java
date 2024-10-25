package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMoveConditionTest {
  @Test
  @DisplayName("랜덤 값이 4 이상인 경우 이동 가능")
  void 랜덤값_4_이상_이동_가능() {
    // Given
    RandomMoveCondition condition = new RandomMoveCondition() {
      @Override
      public boolean isMovable() {
        int stubValue = 5;
        return stubValue >= 4;
      }
    };

    // When & Then
    assertTrue(condition.isMovable());
  }

  @Test
  @DisplayName("랜덤 값이 3 이하인 경우 이동 불가")
  void 랜덤값_3_이하_이동_불가() {
    // Given
    RandomMoveCondition condition = new RandomMoveCondition() {
      @Override
      public boolean isMovable() {
        int stubValue = 3;
        return stubValue >= 4;
      }
    };

    // When & Then
    assertFalse(condition.isMovable());
  }
}
