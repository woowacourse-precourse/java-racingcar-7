package racingcar.view;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class InputViewTest {
    @Test
    void 문자열_쉼표_구분하여_분리() {
        String input = "pobi,jun,seok";

        List<String> tokens = InputView.splitStringByDelimiters(input, ",");

        assertThat(tokens).containsExactly("pobi", "jun", "seok");
    }

    @Test
    void 공백_제거() {
        String input = "  pobi,   ju  n  , s e o k   ";

        String result = InputView.removeSpace(input);

        assertThat(result).isEqualTo("pobi,jun,seok");
    }
}
