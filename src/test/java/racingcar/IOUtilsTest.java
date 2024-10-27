package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class IOUtilsTest {
    @Test
    void String_쉼표를_기준으로_파싱() {
        String input = "abc,bcd,asde,aaa";

        List<String> splitInput = IOUtils.splitInput(input);

        assertEquals(4, splitInput.size());
    }

    @Test
    void List_형식에_맞춰_출력() {
        List<String> list = List.of("abc", "bcd");

        String result = IOUtils.resultOutput(list);

        assertEquals("abc, bcd", result);
    }

    @Test
    void 공백_포함_String_에러발생() {
        String input = "abc,bcd,,aaa";

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }

    @Test
    void 문자열_마지막에_쉼표_에러발생() {
        String input = "abc,bcd,,aaa,";

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }

    @Test
    void 빈_문자일때_에러발생() {
        String input = "";

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }

    @Test
    void 공백시_에러발생() {
        String input = " ";

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }

    @Test
    void 중간에_공백_포함되어있을_때_오류발생() {
        String input = "abc,bcd, ,aaa,";

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }

    @Test
    void null_일때_에러발생() {
        String input = null;

        assertThatThrownBy(() -> IOUtils.splitInput(input)).hasMessage("입력된 이름 중 빈 문자가 존재합니다.");
    }
}