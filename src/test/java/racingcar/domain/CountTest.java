package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {
    @Test
    void 카운트는_양수_이어야한다() {
        assertThatThrownBy(() -> Count.newInstance(0)).isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("시도할 횟수는 최소 1 이상의 양의 정수이어야 합니다.");
    }

    @Test
    void 카운트를_감소_시킬수있다() {
        Count count = Count.newInstance(3);
        Count newCount = count.decrement();
        assertThat(newCount.count()).isEqualTo(2);
    }

    @Test
    void 카운트가_완료_되었는지_확인() {
        Count count = Count.newInstance(5);
        for (int i = 0; i < 5; i++) {
            count = count.decrement();
        }
        assertThat(count.isComplete()).isTrue();
    }
}