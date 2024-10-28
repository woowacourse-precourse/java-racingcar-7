package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class UserTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 유저_자동차이름_입력() {
        String input = "test1, test2, test3";
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
    void 유저_중복_자동차이름_입력() {
        String input = "test1, test2, test3, test3";
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

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(User.inputGameRepeats()).isEqualTo(5);
    }

    @Test
    void 유저_게임횟수_공백_입력() {
        String input = " ";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_게임횟수_공백포함_정수_입력() {
        String input = " 123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(User.inputGameRepeats()).isEqualTo(123);
    }

    @Test
    void 유저_게임횟수_0_입력() {
        String input = "0";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_게임횟수_정수가_아닌_값_입력() {
        String input = "abc";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(User::inputGameRepeats).isInstanceOf(IllegalArgumentException.class);
    }
}