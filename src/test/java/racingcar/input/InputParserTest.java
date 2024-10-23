package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(cars.size(), 2);
        assertEquals(cars.get(0), "pobi");
        assertEquals(cars.get(1), "woni");
    }

    @Test
    void 쉼표_사이에_공백이_존재하는_경우() {
        assertThatThrownBy(() -> inputParser.toList("pobi, woni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_사이에_공백이_존재하는_경우() {
        assertThatThrownBy(() -> inputParser.toList("pobi,wo ni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름은_5자_이하만_가능() {
        assertThatThrownBy(() -> inputParser.toList("pobiden,woni"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
