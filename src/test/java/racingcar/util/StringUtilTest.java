package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class StringUtilTest {
    @Test
    void 콤마_split() {
        assertThat(StringUtil.getCarNames("pobi,woni,jun"))
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 이름_공백_strip() {
        assertThat(StringUtil.getCarNames("  pobi, woni,  jun   "))
                .containsExactly("pobi", "woni", "jun");

    }

    @Test
    void 구분자_콤마_아닐_때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtil.getCarNames("pobi:woni:jun"))
                .withMessageMatching("자동차 이름은 콤마로 구분해야 합니다");
    }

    @Test
    void 이름_길이_5자_초과() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtil.getCarNames("pobi,yellow"))
                .withMessageMatching("자동차 이름은 5자 이하로 설정해야 합니다");
    }
}
