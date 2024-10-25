package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
  @Test
  @DisplayName("자동차 이름 입력 안내 메시지를 출력한다.")
  void 자동차_이름_입력_안내_메시지_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // When
    OutPutView.printCarNamePrompt();

    // Then
    String expectedMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    assertEquals(expectedMessage, outContent.toString());

    // Reset the standard output stream
    System.setOut(System.out);
  }
}
