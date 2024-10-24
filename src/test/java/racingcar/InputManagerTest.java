package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @DisplayName("사용자에게 입력받으면 입력받은 데이터를 그대로 반환해야 한다.")
    @Test
    void getUserInput() {
        //given
        String userInput = "this is test message";
        InputStream inputStream = getInputStream(userInput);
        System.setIn(inputStream);

        //when
        String result = InputManager.readUserInput();

        //then
        assertThat(result).isEqualTo(userInput);
    }

    @DisplayName("빈 문자열을 입력받을 경우 예외를 발생시킨다.")
    @Test
    void emptyUserInput() {
        //given
        String userInput = "\n";
        InputStream inputStream = getInputStream(userInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> InputManager.readUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    private InputStream getInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}