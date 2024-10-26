package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class InputUtilTest {
    private final InputUtil inputUtil = new InputUtil();

    @Test
    void convertToList() {
        assertThat(inputUtil.convertToList("pobi,woni,jun")).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }

    @Test
    void validateCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputUtil.validateCarName("자동차111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void convertToInt_정상() {
        assertThat(inputUtil.convertToInt("10")).isEqualTo(10);
    }

    @Test
    void convertToInt_숫자_아닌_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputUtil.convertToInt("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}