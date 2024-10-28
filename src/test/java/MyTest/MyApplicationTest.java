package MyTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import racingcar.Utils.InputValidator;
import org.junit.jupiter.api.Test;

public class MyApplicationTest {

    @Test
    public void inputCarName_메서드_사용시_쉼표로_구분() {
        String input = "a,ab,abcde";
        String[] result = input.split(",");
        String[] expected = {"a", "ab", "abcde"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void inputCarName_메서드_사용시_쉼표로_구분2() {
        String input = "a,ab,abcde";
        String[] result = input.split(",".trim());
        String[] expected = {"a", "ab", "abcde"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void 자동차_이름_생성시_문자와_숫자_사용가능() {
        String input = "a3,B2";
        String[] result = input.split(",");
        String[] expected = {"a3", "B2"};
        assertArrayEquals(expected, result);
    }

    @Test
    void 자동차_이름에_특수문자_금지(){
        String input = "ab/";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carNameTextAndNumberOtherThanException(input);
        });
    }

    @Test
    void 자동차_이름에_스페이스_금지(){
        String input = "ab d";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carNameTextAndNumberOtherThanException(input);
        });
    }

    @Test
    void 자동차_이름이_5자를_초과하지_않는_지_테스트(){
        String input = "abcdef";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carNameMoreThan5TextException(input);
        });
    }

    @Test
    void null_값_금지(){
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNotNullOrEmpty(input);
        });
    }

    @Test
    void 빈_칸_금지(){
        String input = " ";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNotNullOrEmpty(input);
        });
    }

    @Test
    void 자동차를_두_대_이상_입력했는_지_테스트(){
        String input = "abc";
        String[] inputSplit = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isAtLeastTwoCars(inputSplit);
        });
    }

    @Test
    void racingRace_정상_실행_테스트(){

    }
}
