package racingcar.value;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveForwardTest {

    @Test
    void value가_4_이상이라면_전진할_수_있다() {
        long moveValue = 5;

        MoveForward moveForward = MoveForward.from(moveValue);

        assertThat(moveForward.isMovable()).isTrue();
    }

    @Test
    void value가_4_미만이라면_전진할_수_없다() {
        long moveValue = 3;

        MoveForward moveForward = MoveForward.from(moveValue);

        assertThat(moveForward.isMovable()).isFalse();
    }
}