package racingcar.game.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Counter 를 테스트한다.")
class CounterTest {

    @DisplayName("Counter 의 초기값이 0 이면 성공한다.")
    @Test
    void testCounter1() {
        // given
        Counter counter = new Counter();

        // when
        int count = counter.getCount();

        // then
        assertThat(count).isEqualTo(0);
    }

    @DisplayName("Counter 가 1씩 증가하면 성공한다.")
    @Test
    void testCounter2() {
        // given
        Counter counter = new Counter();

        // when
        counter.increase();

        // then
        assertThat(counter.getCount()).isEqualTo(1);
    }

    @DisplayName("Counter 의 증가한 횟수가 동일하면 성공한다. (1)")
    @Test
    void testCounter3() {
        // given
        Counter counter = new Counter();

        // when
        counter.increase();
        counter.increase();

        // then
        assertThat(counter.getCount()).isEqualTo(2);
    }

    @DisplayName("Counter 의 증가한 횟수가 동일하면 성공한다. (2)")
    @Test
    void testCounter4() {
        // given
        Counter counter = new Counter();

        // when
        counter.increase();
        counter.increase();

        // then
        assertThat(counter.matchesCount(2)).isTrue();
    }
}