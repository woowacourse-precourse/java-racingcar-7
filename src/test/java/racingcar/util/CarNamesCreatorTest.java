package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarNamesCreatorTest {
    @Test
    void 콤마_기준_split() {
        assertThat(CarNamesCreator.createCarNames("pobi,nana,jun"))
                .containsExactly("pobi", "nana", "jun");
    }

    @Test
    void 자동차_이름_공백_제거() {
        assertThat(CarNamesCreator.createCarNames(" pobi  , nana  ,   jun  "))
                .containsExactly("pobi", "nana", "jun");

    }
}
