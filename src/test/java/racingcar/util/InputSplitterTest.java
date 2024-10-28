package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class InputSplitterTest {

    @Test
    @DisplayName("입력값을 쉼표(,)를 기준으로 분리한다.")
    void splitByComma() {
        //given
        String input = "abc,def,ghi";

        //when
        List<String> splitInput = InputSplitter.splitByComma(input);
        List<String> expectedInput = List.of("abc", "def", "ghi");

        //then
        Assertions.assertThat(expectedInput).hasSameElementsAs(splitInput);
    }
}