package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    private static final String CAR_NAME = "pobi";
    private static final String NEGATIVE_ROUND = "-1";
    @Test
    void 시도_횟수_테스트() {
        String attempt = "2";
        int expected = 2;

        Parser parser = new Parser(List.of(CAR_NAME, attempt));
        int parseRound = parser.parseRaceRoundInput();

        assertThat(parseRound).isEqualTo(expected);
    }

    @Test
    void 음수_시도_횟수_예외_테스트() {
        Parser parser = new Parser(List.of(CAR_NAME, NEGATIVE_ROUND));
        assertThatThrownBy(parser::parseRaceRoundInput)
                .isInstanceOf(IllegalArgumentException.class);

    }
}
