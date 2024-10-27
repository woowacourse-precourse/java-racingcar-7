package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorParserTest {

    private SeparatorParser separatorParser = new SeparatorParser();

    @DisplayName("','로 이어진 문자열을 각각의 이름으로 나눈다.")
    @Test
    void splitNamesWhenInputWithCommaSeparated() {
        // given
        String input = "pobi,youngtae,alis";

        // when
        String[] carNames = separatorParser.parseCarNames(input);

        // then
        assertAll(
                () -> assertThat(carNames[0]).isEqualTo("pobi"),
                () -> assertThat(carNames[1]).isEqualTo("youngtae"),
                () -> assertThat(carNames[2]).isEqualTo("alis")
        );
    }
}