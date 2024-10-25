package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @AfterEach
    void rollback() {
        Console.close();
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

    @DisplayName("시도 횟수를 받을 때 1 부터 2147483647 의 범위를 가지는 숫자를 받아야한다.")
    @Test
    void invalidIntRangeUserInput() {
        //given
        String userInput = "2147483648";
        InputStream inputStream = getInputStream(userInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> InputManager.readTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 부터 2147483647 까지의 정수값만 입력할 수 있습니다.");
    }

    @DisplayName("시도 횟수를 받을 때 문자열을 입력받으면 안된다.")
    @Test
    void invalidtypeUserInput() {
        //given
        String userInput = "String";
        InputStream inputStream = getInputStream(userInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> InputManager.readTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 부터 2147483647 까지의 정수값만 입력할 수 있습니다.");
    }

    @DisplayName("1 부터 2147483647 까지의 입력을 받을 경우 정수형으로 형변환해 반환해야 한다.")
    @Test
    void intRangeUserInput() {
        //given
        String userInput = "1";
        InputStream inputStream = getInputStream(userInput);
        System.setIn(inputStream);

        //when
        int tryCount = InputManager.readTryCount();

        //then
        assertThat(tryCount).isEqualTo(1);
    }

    private InputStream getInputStream(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}