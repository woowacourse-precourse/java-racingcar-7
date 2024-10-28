package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

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

    @Test
    void 자동차_리스트_생성에_성공한다() {
        assertThatCode(() -> new CarList("pobi,woni"))
                .doesNotThrowAnyException();
    }
}
