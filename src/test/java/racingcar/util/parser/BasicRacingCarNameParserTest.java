package racingcar.util.parser;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BasicRacingCarNameParserTest {

    private final BasicRacingCarNameParser basicRacingCarNameParser;

    public BasicRacingCarNameParserTest() {
        basicRacingCarNameParser = new BasicRacingCarNameParser();
    }

    @Test
    void 자동차_이름_분리_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "창의, 지후, 보성";
            List<String> nameList = List.of("창의", "지후", "보성");

            // when
            List<String> result = basicRacingCarNameParser.parseNamesStringToList(names);

            // then
            assertThat(result).usingRecursiveComparison().isEqualTo(nameList);

        });
    }

}
