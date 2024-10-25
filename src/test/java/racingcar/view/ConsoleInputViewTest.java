package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputViewTest {

    ConsoleInputView inputView = new ConsoleInputView();

    @Test
    @DisplayName("사용자가 빈 문자열을 입력하면 예외가 발생한다.")
    public void 사용자_입력_기능_예외() {
        //given
        String userInput = "\n";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //when then
        Assertions.assertThatThrownBy(() -> inputView.getValidatedUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }
}