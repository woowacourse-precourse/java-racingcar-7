package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputUserTest {
    @Test
    @DisplayName("정상 입력 테스트 - 길이 5이하 이름 입력")
    public void inputStringOkTest() {
        InputUser inputUser = new InputUser();

        String input = "apple,grape,melon";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = inputUser.inputNames();

        Assertions.assertThat("[apple, grape, melon]").isEqualTo(result.toString());
    }

    @Test
    @DisplayName("비정상 입력 테스트 - 길이 5초과 이름 입력")
    public void inputStringErrorTest() {
        InputUser inputUser = new InputUser();

        String input = "orange,grape,melon";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> inputUser.inputNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 입력 테스트 - 숫자입력")
    public void inputNumberOkTest() {
        InputUser inputUser = new InputUser();

        String input = "5";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int number  = inputUser.inputNumber();

        Assertions.assertThat(5).isEqualTo(number);
    }

    @Test
    @DisplayName("비정상 입력 테스트 - 문자입력")
    public void inputNumberErrorTest() {
        InputUser inputUser = new InputUser();

        String input = "apple";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> inputUser.inputNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}