package separator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("자동차 이름 구분 예외 테스트(null, blank)")
    void split_X() {
        //when
        String valueOfBlank = "";
        String valueOfNull = null;
        String valueOfSpace = " ,  ";
        //then
        assertThrows(IllegalArgumentException.class, () -> Separator.split(valueOfBlank));
        assertThrows(IllegalArgumentException.class, () -> Separator.split(valueOfNull));
        assertThrows(IllegalArgumentException.class, () -> Separator.split(valueOfSpace));
    }

    @Test
    void 연속된_구분자() {
        //when
        String repeatedSeparator = "pobi,woni,,jun";
        //then
        assertThrows(IllegalArgumentException.class, () -> Separator.split(repeatedSeparator));
    }

    @Test
    void 자동차_이름_중복() {
        //when
        String duplicatedName = "pobi,jun,pobi";
        //then
        assertThrows(IllegalArgumentException.class, () -> Separator.split(duplicatedName));
    }
}