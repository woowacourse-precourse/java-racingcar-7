package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차_이름이_하나만_입력되었을_때_실패한다() {
        String carNames = "pobi";
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_중복일_때_실패한다() {
        String carNames = "pobi,woni,pobi";
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차들_생성에_성공한다() {
        String carNames = "pobi,woni";
        assertThatCode(() -> new Cars(carNames))
                .doesNotThrowAnyException();
    }
}
