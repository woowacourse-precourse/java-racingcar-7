package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("메세지 출력 테스트")
    public void 메세지_출력_테스트() {
        // given
        String message = "Hello, world!";
        String newLine = "\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        outputView.println(message);

        // then
        assertThat(outputStream.toString()).isEqualTo(message + newLine);
    }

}