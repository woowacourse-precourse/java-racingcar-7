package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputSeparatorTest {

    @Test
    @DisplayName("자동차 이름 구분 테스트")
    void split() {
        //when
        List<String> output = InputSeparator.split("pobi,woni,jun");
        List<String> expected = List.of("pobi", "woni", "jun");
        //then
        Assertions.assertThat(output).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 구분 예외 테스트")
    @NullAndEmptySource
    void split_X(String empty) {
        //when
        String valueOfSpace = " ,  ";
        //then
        assertThrows(IllegalArgumentException.class, () -> InputSeparator.split(empty));
        assertThrows(IllegalArgumentException.class, () -> InputSeparator.split(valueOfSpace));
    }

    @Test
    void 연속된_구분자() {
        //when
        String repeatedSeparator = "pobi,woni,,jun";
        //then
        assertThrows(IllegalArgumentException.class, () -> InputSeparator.split(repeatedSeparator));
    }

    @Test
    void 자동차_이름_중복() {
        //when
        String duplicatedName = "pobi,jun,pobi";
        //then
        assertThrows(IllegalArgumentException.class, () -> InputSeparator.split(duplicatedName));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 5자 초과")
    @ValueSource(strings = {"pobi,javaji","junjun", "pobi,jun,woni,ouvir,6langs"})
    void 자동차_이름_5자_이상(String overLengthName) {
        assertThrows(IllegalArgumentException.class, () -> InputSeparator.split(overLengthName));
    }
}