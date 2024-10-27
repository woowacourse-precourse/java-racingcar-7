package racingcar.parser;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNamesParserTest {

    @Test
    void parse_should_be_pass() {
        // given
        String input = "pobi,woni,jun";
        Parser<String, List<String>> parser = new CarNamesParser();
        // when
        List<String> result = parser.parse(input);
        // then
        Assertions.assertEquals(List.of("pobi", "woni", "jun"), result);
    }

    @Test
    void parse_given_중복_자동차이름_then_remove_duplicated() {
        // given
        String input = "pobi,woni,jun,pobi, woni,june";
        Parser<String, List<String>> parser = new CarNamesParser();
        // when
        List<String> result = parser.parse(input);
        // then
        Assertions.assertEquals(List.of("pobi", "woni", "jun", "june"), result);
    }
}