package racingcar.view.input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.input.dto.RacingRequest;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class InputViewTest {

  private ByteArrayOutputStream outputStream;
  private InputStream originalIn;
  private PrintStream originalOut;

  @BeforeEach
  void setUp() {
    outputStream = new ByteArrayOutputStream();
    originalIn = System.in;
    originalOut = System.out;
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  @DisplayName("[Success]promptRacingRequest : 사용자 입력 기능 테스트")
  void promptRacingRequest() {
    assertDoesNotThrow(() -> {
      String input = "james,jane\n3\n";
      InputStream in = new ByteArrayInputStream(input.getBytes());
      System.setIn(in);

      RacingRequest request = InputView.promptRacingRequest();

      assertEquals(request.carNames(), "james,jane");
      assertEquals(request.roundCount(), 3);
      assertTrue(outputStream.toString()
          .contains("이름"));
      assertTrue(outputStream.toString()
          .contains("횟수"));
    });
  }

  @AfterEach
  void tearDown() {
    System.setIn(originalIn);
    System.setOut(originalOut);
  }
}