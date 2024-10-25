package racingcar.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void 이름_입력값_컬렉션_반환() {
        List<String> cars = inputParser.toList("pobi,woni");

        assertSimpleTest(() ->
                assertThat(cars.size()).as("cars size").isEqualTo(2)
        );

        assertSimpleTest(() ->
                assertThat(cars).contains("pobi", "woni")
        );
    }

    @Test
    void 쉼표_사이에_공백이_존재하는_경우() {
        assertThatThrownBy(() -> inputParser.toList("pobi, woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 사이에 공백이 존재해서는 안됩니다.")
                // check start
                .hasMessageStartingWith("이름")
                // check contain
                .hasMessageContaining("이름 사이")
                // check end
                .hasMessageEndingWith("안됩니다.")
                // check regex
                .hasMessageMatching("이름 사이에 .*")
                // check does not contain
                .hasMessageNotContaining("체크");
    }

    @Test
    void 이름_사이에_공백이_존재하는_경우() {
        assertSimpleTest(() ->
                assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> inputParser.toList("pobi,wo ni"))
        );

        assertSimpleTest(() ->
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> inputParser.toList("pobi,wo ni"))
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputParser.toList("pobi,wo ni"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름은_5자_이하만_가능() {
        assertThatThrownBy(() -> inputParser.toList("pobiden,woni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
