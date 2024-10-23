package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class ExtractNameTest {

    @Test
    void extractName_ShouldReturnTrimmedNames() {
        ExtractName extractor = new ExtractName();
        String input = " car1 , car2 , car3 ,   ";

        String[] result = extractor.extractName(input);

        String[] expected = {"car1", "car2", "car3", ""};
        assertArrayEquals(expected, result);
    }

    @Test
    void extractName_ShouldReturnEmptyList_WhenInputIsEmpty() {
        ExtractName extractor = new ExtractName();
        String input = "";

        String[] result = extractor.extractName(input);

        String[] expected = {""};
        assertArrayEquals(expected, result);
    }

    @Test
    void extractName_ShouldHandleSingleName() {
        ExtractName extractor = new ExtractName();
        String input = "car1";

        String[] result = extractor.extractName(input);

        String[] expected = {"car1"};
        assertArrayEquals(expected, result);
    }

    @Test
    void extractName_ShouldHandleNamesWithExtraSpaces() {
        ExtractName extractor = new ExtractName();
        String input = "  car1  ,   car2  , car3 ";

        String[] result = extractor.extractName(input);

        String[] expected = {"car1", "car2", "car3"};
        assertArrayEquals(expected, result);
    }
}
