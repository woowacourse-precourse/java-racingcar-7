package racingcar.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {
    @Test
    void 구분자_사이_문자가_없는지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                ConsoleReader.readName("abc,,umu"));
    }
    @Test
    void 중복되는_이름이_있는지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                ConsoleReader.readName("abc,abc"));
    }

    @Test
    void 이름이_5자_이상인지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                ConsoleReader.readName("abcdefg"));
    }
}