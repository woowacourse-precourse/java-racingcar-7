package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_이름이_5자를_넘어간다면_예외_처리() {
        assertThatThrownBy(() -> new Car(new RandomEngine(), "5글자넘어가기"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}