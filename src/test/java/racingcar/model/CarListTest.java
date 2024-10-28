package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarListTest {
    @Test
    void 자동차_이름이_하나만_입력되었을_때_실패한다() {
        assertThatThrownBy(() -> new CarList("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_중복일_때_실패한다() {
        assertThatThrownBy(() -> new CarList("pobi,woni,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",woni,jun", "pobi,,jun", "pobi,woni,"})
    void 자동차_이름이_중간에_비어있을_때_실패한다(String carNames) {
        assertThatThrownBy(() -> new CarList(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_리스트_생성에_성공한다() {
        assertThatCode(() -> new CarList("pobi,woni"))
                .doesNotThrowAnyException();
    }
}
