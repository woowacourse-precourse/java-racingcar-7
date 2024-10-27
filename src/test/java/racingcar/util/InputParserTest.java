package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("5자 이상 이름 입력")
    void meetsCarNameOverFive_Then_Exception() {
        // given
        String inputString = "pobi,woni,javaji";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseInput(inputString));
    }

    @Test
    @DisplayName("정상적인 입력 시")
    void meetsCarCountOneOrMore_Then_Success() {
        // given
        String inputString = "pobi";

        // when
        List<Car> carList = InputParser.parseInput(inputString);

        // then
        assertEquals("pobi", carList.get(0).getName());
    }
}