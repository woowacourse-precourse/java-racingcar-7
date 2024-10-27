package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 차_이름이_5글자를_넘으면_에러() {
        assertThatThrownBy(() ->
                new Car("chxxry"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름이_한글자_미만이면_에러() {
        assertThatThrownBy(() ->
                new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름이_1글자_이상_5글자_이하면_생성() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }
}