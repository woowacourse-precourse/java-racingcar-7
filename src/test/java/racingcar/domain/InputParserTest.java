package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void 자동차_이름_파싱() {
        String carNamesInput = "lucku,kimchi";
        List<String> carNames = InputParser.parseCarNames(carNamesInput);
        assertThat(carNames).containsExactly("lucku", "kimchi");
    }

    @Test
    void 시도할_횟수_파싱() {
        String roundsInput = "5";
        int rounds = InputParser.parseRounds(roundsInput);
        assertThat(rounds).isEqualTo(5);
    }
}
