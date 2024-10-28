package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    public void Given_Racing_객체_When_isProgress_호출시_이동_횟수가_남아있으면_True를_반환한다() {
        final Racing racing = new Racing();
        racing.saveTryCount(4);

        assertThat(racing.isProgress()).isTrue();
    }

    @Test
    public void Given_Racing_객체_When_이동_횟수_차감_메서드_호출시_이동_횟수가_0이면_False를_반환한다() {
        final Racing racing = new Racing();
        racing.saveTryCount(1);
        racing.minusTryCount();

        assertThat(racing.isProgress()).isFalse();
    }

    @Test
    public void Given_Racing_객체_When_이동_횟수_저장_후_0이면_False를_반환한다() {
        final Racing racing = new Racing();
        racing.saveTryCount(0);

        assertThat(racing.isProgress()).isFalse();
    }

    @Test
    public void Given_Racing_객체_When_1회차_이동후_이동_횟수가_남아있을때_isProgress_호출시_True를_반환한다() {
        final Racing racing = new Racing();
        racing.saveTryCount(2);
        racing.minusTryCount();

        assertThat(racing.isProgress()).isTrue();
    }
}