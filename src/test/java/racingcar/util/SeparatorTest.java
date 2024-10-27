package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SeparatorTest {

    @Test
    void splitWithComma_문자열_분할_성공() {
        // given
        String input = "pobi,woni,ken";

        // when
        String[] result = Separator.splitWithComma(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "ken");
    }

    @Test
    void splitWithComma_구분자_없는_문자열_분할_성공() {
        // given
        String input = "pobi";

        // when
        String[] result = Separator.splitWithComma(input);

        // then
        assertThat(result).containsExactly("pobi");
    }

}
