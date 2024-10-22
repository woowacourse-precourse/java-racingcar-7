package racingcar;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("read 메서드 입력 테스트")
    public void read_입력_테스트() {
        // given
        String command = "pobi,woni,jun";

        InputStream in = new ByteArrayInputStream(command.getBytes());
        System.setIn(in);

        // when & then
        Assertions.assertThat(inputView.read())
                .isEqualTo(command);
    }

}