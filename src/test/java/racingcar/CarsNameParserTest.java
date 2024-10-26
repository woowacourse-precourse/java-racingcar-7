package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.CarsNameParser.parse;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsNameParserTest {


    @Test
    @DisplayName("자동차 목록 문자열을 \",\" 기준으로 구분한다: 기능 목록 1번")
    void parseCarNames() {
        //given
        String input ="pobi,ddotzy,teddy";
        //when
        Set carsName = parse(input);
        //then
        assertEquals(Set.of("pobi", "ddotzy", "teddy"), carsName);
    }

}