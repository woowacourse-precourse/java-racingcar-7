package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    void extractCarNamesTest() {
        // given
        String input = "class,dkdk,dldl,";
        // when
        List<RacingCar> list = Parser.extractCarNames(input);
        // then
        assertEquals(3, list.size());
    }

    @Test
    void parseNumberTest() {
        // given
        String count = "ss";
        // when & then
        Assertions.assertThatThrownBy(() -> Parser.parseNumber(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}