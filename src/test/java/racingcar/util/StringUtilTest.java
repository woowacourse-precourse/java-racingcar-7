package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    @DisplayName("쉼표(,)로 문자열을 파싱한다.")
    void splitByComma() {
        String input = "pobi,woni,jun";
        String[] strings = StringUtil.splitByComma(input);
        assertThat(strings).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("문자열 배열을 ArrayList로 변환한다.")
    void toArrayList() {
        String[] input = {"pobi", "woni", "jun"};
        ArrayList<String> result = StringUtil.toArrayList(input);

        assertThat(result)
                .isInstanceOf(ArrayList.class)
                .containsExactly("pobi", "woni", "jun");
    }
}