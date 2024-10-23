package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitterTest {
    private static String testInput;

    @Test
    void 공백만_있는_입력은_허용되지_않는다() {
        testInput = "   ";
        Splitter splitter = new Splitter(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, splitter::parsingCarName);
    }

    @Test
    void 중복_입력_요소는_허용되지_않는다() {
        testInput = "test1,test2,test1";
        Splitter splitter = new Splitter(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, splitter::parsingCarName);
    }

    @Test
    void 입력_요소는_5자_이하만_허용된다() {
        testInput = "test1,test2,test111111111111111";
        Splitter splitter = new Splitter(testInput);
        Assertions.assertThrows(IllegalArgumentException.class, splitter::parsingCarName);
    }

    @AfterEach
    void clean() {
        testInput = "";
    }
}
