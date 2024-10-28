package racingcar.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    void 이름_파싱_테스트() {
        // given
        String input = "pobi,woni,jun";
        // when
        String[] result = Parser.parseName(input);
        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 빈_문자열_파싱_테스트() {
        // given
        String input = "";
        // when
        String[] result = Parser.parseName(input);
        // then
        assertThat(result).containsExactly("");
    }

    @Test
    void 쉼표만_포함된_문자열_테스트() {
        // given
        String input = ",";
        // when
        String[] result = Parser.parseName(input);
        // then
        assertThat(result).containsExactly("", "");
    }
}
