package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void beforeEach() {
        parser = new Parser();
    }

    @Test
    @DisplayName("자동차 이름을 파싱하여 리스트로 반환하는 테스트")
    void parseCarNames() {
        // given
        String carNamesInput = "pobi, woni, jun";

        // when
        List<String> carNames = parser.parseCarNames(carNamesInput);

        // then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}