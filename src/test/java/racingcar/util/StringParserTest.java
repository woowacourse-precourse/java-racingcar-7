package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class StringParserTest {

    @Nested
    class 문자열_파싱_성공 {

        @Test
        void 공백_없음() {
            //given
            final String input = "pobi,woni,jun";
            final String[] expected = {"pobi" , "woni", "jun"};

            //when
            Set<String> parsed = StringParser.parseCarName(input);

            //then
            assertThat(parsed).containsExactlyInAnyOrder(expected);
        }

        @Test
        void 공백_있음() {
            //given
            final String input = "pobi, woni  ,    jun";
            final String[] expected = {"pobi" , "woni", "jun"};


            //when
            Set<String> parsed = StringParser.parseCarName(input);

            //then
            assertThat(parsed).containsExactlyInAnyOrder(expected);
        }
    }
}