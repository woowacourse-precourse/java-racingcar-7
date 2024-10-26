package racingcar.parser;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNamesParserTest {

    @Test
    void parse_should_be_pass() {
        // given
        String input = "pobi,woni,jun";
        Parser<String, List<String >> parser = new CarNamesParser();
        // when
        List<String> result = parser.parse(input);
        // then
        Assertions.assertEquals(List.of("pobi", "woni", "jun"), result);
    }

    @Test
    void parse_given_중복_자동차이름_then_remove_duplicated() {
        // given
        String input = "pobi,woni,jun,pobi, woni,june";
        Parser<String, List<String >> parser = new CarNamesParser();
        // when
        List<String> result = parser.parse(input);
        // then
        Assertions.assertEquals(List.of("pobi", "woni", "jun", "june"), result);
    }

    @Test
    void parse_given_blank_input_then_should_be_fail() {
        // given
        String input = " ";
        Parser<String, List<String >> parser = new CarNamesParser();
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        Assertions.assertEquals("자동차 입력을 입력해주세요.", ex.getMessage());
    }

    @Test
    void parse_given_6글자_이상의_자동차이름_then_should_be_fail() {
        // given
        String input = "pobi,woni,jun,hseungh";
        Parser<String, List<String >> parser = new CarNamesParser();
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        Assertions.assertEquals("자동차 이름은 5 글자를 초과할 수 없습니다.", ex.getMessage());
    }

    @Test
    void parse_given_11개_자동차이름_then_should_be_fail() {
        // given
        String input = "one,two,three,four,five,six,seven,eight,nine,ten,over";
        Parser<String, List<String >> parser = new CarNamesParser();
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        Assertions.assertEquals("자동차 이름은 최대 10개까지만 입력할 수 있습니다.", ex.getMessage());
    }
}
