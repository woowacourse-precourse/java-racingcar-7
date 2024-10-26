package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class CarNamesCreatorTest {
    @Test
    void 콤마_기준_split() {
        assertThat(CarNamesCreator.createCarNames("pobi,nana,jun"))
                .containsExactly("pobi", "nana", "jun");
    }

    @Test
    void 콤마로_split_할_수_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNamesCreator.createCarNames("pobi:nana,jun"))
                .withMessageMatching("자동차 이름은 콤마로 구분해야 합니다");
    }

    @Test
    void 자동차_이름_공백_제거() {
        assertThat(CarNamesCreator.createCarNames(" pobi  , nana  ,   jun  "))
                .containsExactly("pobi", "nana", "jun");

    }
}
