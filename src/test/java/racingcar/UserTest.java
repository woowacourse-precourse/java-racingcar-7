package racingcar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {

    @Test
    void 유저_자동차이름_입력() {
        String input = "test1, test2, test3";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> ansResult = new ArrayList<>();
        ansResult.add("test1");
        ansResult.add("test2");
        ansResult.add("test3");

        List<String> result = User.inputCarNames();

        Assertions.assertThat(result).isEqualTo(ansResult);
    }

    @Test
    void 유저_게임횟수_입력() {
        String input = "5";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(User.inputGameRepeats()).isEqualTo(5);
    }

    @Test
    void 유저_게임횟수_공백_입력() {
        String input = " ";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_게임횟수_공백포함_정수_입력() {
        String input = " 123";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(User.inputGameRepeats()).isEqualTo(123);
    }

    @Test
    void 유저_게임횟수_0_입력() {
        String input = "0";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_게임횟수_정수가_아닌_값_입력() {
        String input = "abc";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }
}