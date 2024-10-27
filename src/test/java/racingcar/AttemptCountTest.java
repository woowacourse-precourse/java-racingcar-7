package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptCountTest {

    @Test
    void 잘못된_시도_횟수_테스트() {
        assertThatThrownBy(() ->
                RacingCarAppTest.run("mini,woni", "invalid"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
