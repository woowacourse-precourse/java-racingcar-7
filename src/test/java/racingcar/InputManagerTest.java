package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @Test
    @DisplayName("사용자에게 입력받으면 입력받은 데이터를 그대로 반환해야 한다.")
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

    private InputStream getInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}