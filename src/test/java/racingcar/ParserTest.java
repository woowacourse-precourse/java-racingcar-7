package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void 구분자로_자동차_이름_파싱() {
        assertThat(parser.parseCarNamesByOperator("one,two,three,four,five"))
            .isEqualTo(List.of("one", "two", "three", "four", "five"));
    }

    @Test
    void 반복횟수_파싱() {
        assertThat(parser.parseRepeatCount("15"))
            .isEqualTo(15);
    }
}