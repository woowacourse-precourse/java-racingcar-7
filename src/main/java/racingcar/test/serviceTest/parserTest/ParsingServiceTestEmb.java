package racingcar.test.serviceTest.parserTest;

import org.junit.jupiter.api.Test;
import racingcar.service.parser.ParsingService;
import racingcar.service.parser.ParsingServiceEmb;

import static org.assertj.core.api.Assertions.assertThat;

public class ParsingServiceTestEmb implements ParsingServiceTest {
    @Test
    public void testParseCarsIntoList() {
        ParsingService parsingService = new ParsingServiceEmb();
        assertThat(parsingService.parseCarsIntoList("a,b,c")).hasSize(3);
    }

    @Test
    public void testParseStringIntoLong() {
        ParsingService parsingService = new ParsingServiceEmb();
        assertThat(parsingService.parseStringIntoLong("5")).isEqualTo(5);
    }

    @Test
    public void run(){
        testParseCarsIntoList();
        testParseStringIntoLong();
    }
}
