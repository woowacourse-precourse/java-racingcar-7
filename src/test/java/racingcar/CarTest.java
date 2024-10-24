package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 이름이_6글자_이상이면_예외를_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("테스트차량임"));
    }
}