package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RandomMovementStrategy;

public class RandomMovementStrategyTest {

    @Test
    @DisplayName("RandomMovementStrategy 는 4 이상일 때 이동 가능하다")
    void moveableWhenRandomNumberAtLeastFour(){
        RandomMovementStrategy randomMovementStrategy =new RandomMovementStrategy(){
            @Override
            protected int makeRandomNumber() {
                return 4;
            }
        };
        assertThat(randomMovementStrategy.moveable()).isTrue();
    }

    @Test
    @DisplayName("RandomMovementStrategy 는 4 이상일 때 이동 가능하다")
    void notMoveableWhenRandomNumberBelowFour(){
        RandomMovementStrategy randomMovementStrategy =new RandomMovementStrategy(){
            @Override
            protected int makeRandomNumber() {
                return 3;
            }
        };
        assertThat(randomMovementStrategy.moveable()).isFalse();
    }

}
