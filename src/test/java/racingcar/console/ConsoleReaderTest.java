package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

class ConsoleReaderTest {
    private final InputStream initialInput = System.in;
    @AfterEach
    void reset(){
        Console.close();
        System.setIn(initialInput);
    }
    @Test
    void 구분자_사이_문자가_없는지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            String input = "abc,,umu";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ConsoleReader.readName();
        });
    }
    @Test
    void 중복되는_이름이_있는지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            String input = "abc,abc";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ConsoleReader.readName();
        });
    }

    @Test
    void 이름이_5자_이상인지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            String input = "abcdefg";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ConsoleReader.readName();
        });
    }

    @Test
    void 경기횟수가_숫자가_아닌지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            String input = "11a";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ConsoleReader.readNum();
        });
    }

    @Test
    void 경기횟수가_빈_문자열인지_검증한다(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            String input = "\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ConsoleReader.readNum();
        });
    }
}