package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        assertThat(inputParser.executeCarNames("a,b,c,d,e")).hasSize(5);
        assertThat(inputParser.executeCarNames("a.,b,c,d,e")).hasSize(5);
        assertThat(inputParser.executeCarNames("a ,b,c,d,e")).hasSize(5);
    }

    @Test
    void 시도_횟수는_숫자로_반환한다() {
        assertThat(inputParser.executeAttempts("1")).isEqualTo(1);
    }
}
