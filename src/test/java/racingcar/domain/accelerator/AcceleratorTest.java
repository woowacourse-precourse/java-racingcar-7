package racingcar.domain.accelerator;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AcceleratorTest {

    public static final int MOVEABLE_VALUE = 4;
    public static final int IMMOVABLE_VALUE = 3;

    @Test
    void 이동_성공_4이상의_수() {
        // given
        Accelerator accelerator = new RandomAccelerator();

        // when
        boolean movedResult = accelerator.isMovable(MOVEABLE_VALUE);

        // then
        assertThat(movedResult).isTrue();
    }

    @Test
    void 이동_실패_3이하의_수() {
        // given
        Accelerator accelerator = new RandomAccelerator();

        // when
        boolean movedResult = accelerator.isMovable(IMMOVABLE_VALUE);

        // then
        assertThat(movedResult).isFalse();
    }

    @Test
    void 허용가능한_값을_벗어난_경우() {
        // given
        Accelerator accelerator = new RandomAccelerator();

        // when &then
        assertThatThrownBy(() -> {
            accelerator.isMovable(10);
        }).isInstanceOf(BusinessException.class);
    }
}
