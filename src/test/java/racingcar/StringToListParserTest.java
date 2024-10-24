package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToListParserTest {
    private static String testInput;

    @Test
    void 공백만_있는_입력은_허용되지_않는다() {
        testInput = "   ";
        StringToListParser stringToListParser = new StringToListParser(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, stringToListParser::parsingCarName);
    }

    @Test
    void 중복_입력_요소는_허용되지_않는다() {
        testInput = "test1,test2,test1";
        StringToListParser stringToListParser = new StringToListParser(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, stringToListParser::parsingCarName);
    }

    @Test
    void 입력_요소는_5자_이하만_허용된다() {
        testInput = "test1,test2,test111111111111111";
        StringToListParser stringToListParser = new StringToListParser(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, stringToListParser::parsingCarName);
    }

    @AfterEach
    void clean() {
        testInput = "";
    }
}
