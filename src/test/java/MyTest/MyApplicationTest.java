package MyTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.InputMessage;

public class MyApplicationTest {
    InputMessage inputMessage = new InputMessage();
    @Test
    public void inputCarName_메서드_사용시_쉼표로_구분() {
        String input = "a,ab,abcde";
        String[] result = input.split(",");
        String[] expected = {"a", "ab", "abcde"};
        assertArrayEquals(expected, result);
    }
    @Test
    public void inputCarName_메서드_사용시_쉼표로_구분2() {
        String input = "a, ab, abcde";
        String[] result = input.split(",\\s*");
        String[] expected = {"a", "ab", "abcde"};
        assertArrayEquals(expected, result);
    }
    @Test
    public void 자동차_이름_생성시_문자와_숫자_사용() {
        String input = "a3,B2";
        String[] result = input.split(",");
        String[] expected = {"a3", "B2"};
        assertArrayEquals(expected, result);
    }
    @Test
    void 자동차_이름에_특수문자_금지(){
        String input = "abc,ab/";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }
    @Test
    void 자동차_이름에_스페이스_금지(){
        String input = "abc, ab d";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }
    @Test
    void 자동차_이름이_5자를_초과하지_않는_지_테스트(){
        String input = "abc, abcd, abcdef";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }
    @Test
    void null_값_금지(){
        String input = "";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }
    @Test
    void 빈_칸_금지(){
        String input = " ";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }
    @Test
    void 자동차를_두_대_이상_입력했는_지_테스트(){
        String input = "abc";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.validateInput(inputSplit);
        });
    }

    @Test
    void racingRace_정상_실행_테스트(){

    }
}
