package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class NameParserTest {

    @DisplayName("입력된 문자열에서 쉼표로 자동차 이름을 구분한다.")
    @Test
    void 자동차_이름_구분() {
        String text = "pobi,jun,star";
        NameParser nameParser = new NameParser();
        List<String> carNames = nameParser.carNameParse(text);

        Assertions.assertThat(carNames).contains("pobi");
        Assertions.assertThat(carNames).contains("jun");
        Assertions.assertThat(carNames).contains("star");
        Assertions.assertThat(carNames).doesNotContain("junki");
    }
}