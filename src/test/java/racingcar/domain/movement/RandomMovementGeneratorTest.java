package racingcar.domain.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomMovementGeneratorTest {

    @Test
    @DisplayName("랜덤값이 4이상이면 움직인다")
    void CanGoCase() {
        //given
        RandomMovement randomMovement = new RandomMovementGenerator(() -> 4);

        //when
        boolean result = randomMovement.canGo();

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 안움직인다")
    void CantGoCase() {
        //given
        RandomMovement randomMovement = new RandomMovementGenerator(() -> 3);

        //when
        boolean result = randomMovement.canGo();

        //then
        assertThat(result).isFalse();
    }
}