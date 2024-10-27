package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    void 자동차이름_파싱하기() {
        String cars = "pobi,haeyoon,hae";
        String[] result = inputParser.parser(cars);

        assertArrayEquals(new String[] {"pobi", "haeyoon", "hae"}, result);

    }

}