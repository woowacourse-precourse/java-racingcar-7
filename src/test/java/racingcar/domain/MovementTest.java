package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovementTest {
    @Test
    void 전진_시_주어진_숫자가_4_이상이면_전진한다() {
        Movement movement = new Movement();

        movement.advance(4);

        assertThat(movement.getCount()).isEqualTo(1);

        movement.advance(9);

        assertThat(movement.getCount()).isEqualTo(2);
    }

    @Test
    void 전진_시_주어진_숫자가_4_미만이면_전진하지않는다() {
        Movement movement = new Movement();

        movement.advance(3);

        assertThat(movement.getCount()).isEqualTo(0);

        movement.advance(0);

        assertThat(movement.getCount()).isEqualTo(0);
    }

    @Test
    void 전진_시_주어진_숫자가_0에서_9가_아니면_에러를_던진다() {
        Movement movement = new Movement();

        assertThrows(IllegalArgumentException.class, () -> {
            movement.advance(10);
        });
    }
}