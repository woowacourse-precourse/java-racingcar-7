package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_이름이_중복되면_에러() {
        assertThatThrownBy(() ->
                new Cars("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}