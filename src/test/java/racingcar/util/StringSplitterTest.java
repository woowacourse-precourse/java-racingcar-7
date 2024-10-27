package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringSplitterTest {

    @Test
    @DisplayName("문자열 나누기 테스트1 - 성공")
    void splitTest1() throws Exception {
        //given
        String input = "pobi,woni,jun";
        StringSplitter splitter = new StringSplitter();
        List<String> expectNames = List.of("pobi", "woni", "jun");

        //when
        List<String> splitNames = splitter.splitString(input);

        //then
        Assertions.assertThat(splitNames).isEqualTo(expectNames);
    }

    @Test
    @DisplayName("문자열 나누기 테스트2 - 성공")
    void splitTest2() throws Exception {
        //given
        String input = " abc,dkaso,dosak ";
        StringSplitter splitter = new StringSplitter();
        List<String> expectNames = List.of(" abc", "dkaso", "dosak ");

        //when
        List<String> splitNames = splitter.splitString(input);

        //then
        Assertions.assertThat(splitNames).isEqualTo(expectNames);
    }
}