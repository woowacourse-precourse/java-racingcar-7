package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    @DisplayName("입력받은 값의 갯수와 구분자로 자른 요소의 갯수가 일치한다")
    void parse_with_delimiters() {
        String inputs = "오뎅, 김치";

        String[] names = Parser.splitWithDelimiter(inputs);

        Assertions.assertEquals(names.length, 2);
    }
}