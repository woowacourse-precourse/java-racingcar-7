package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

class ExtractNameTest {

    @Test
    void extractName_ShouldReturnTrimmedNames() {
        ExtractName extractor = new ExtractName();
        String input = " car1 , car2 , car3 ,   ";

        List<String> result = extractor.extractName(input);

        List<String> expected = List.of("car1", "car2", "car3", "");
        assertEquals(expected, result);
    }

    @Test
    void extractName_ShouldReturnEmptyList_WhenInputIsEmpty() {
        ExtractName extractor = new ExtractName();
        String input = "";

        List<String> result = extractor.extractName(input);

        List<String> expected = List.of("");
        assertEquals(expected, result);
    }

    @Test
    void extractName_ShouldHandleSingleName() {
        ExtractName extractor = new ExtractName();
        String input = "car1";

        List<String> result = extractor.extractName(input);

        List<String> expected = List.of("car1");
        assertEquals(expected, result);
    }

    @Test
    void extractName_ShouldHandleNamesWithExtraSpaces() {
        ExtractName extractor = new ExtractName();
        String input = "  car1  ,   car2  , car3 ";

        List<String> result = extractor.extractName(input);

        List<String> expected = List.of("car1", "car2", "car3");
        assertEquals(expected, result);
    }
}
