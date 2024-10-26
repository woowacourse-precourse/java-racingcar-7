package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("RandomMoveStrategy 클래스 기능 테스트")
public class RandomMoveStrategyTest {

    @Test
    @DisplayName("랜덤 값이 4 이상일 때 이동 가능 여부는 true이다.")
    void isMovableShouldReturnTrueWhenNumberIsGreaterThanOrEqualToFour() {
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(new FixedRandomGenerator(4));
        assertThat(moveStrategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 때 이동 가능 여부는 false이다.")
    void isMovableShouldReturnFalseWhenNumberIsLessThanFour() {
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(new FixedRandomGenerator(3));
        assertThat(moveStrategy.isMovable()).isFalse();
    }
}
