package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;

public class ViewTest {

  @Test
  @DisplayName("자동차 이름과 시도 횟수 입력을 정상적으로 받는다.")
  void 자동차_이름_과_시도_횟수_입력_정상_수신() {
    System.setIn(new ByteArrayInputStream("pobi, jun, car1\n5\n".getBytes()));

    String carNames = InputView.getCarNames();
    String tryCount = InputView.getTryCount();

    assertEquals("pobi, jun, car1", carNames);
    assertEquals("5", tryCount);
  }

  @Test
  @DisplayName("자동차 이름 입력 안내 메시지를 출력한다.")
  void 자동차_이름_입력_안내_메시지_출력() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    OutputView.printCarNamePrompt();

    assertEquals(
        "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator(),
        outContent.toString()
    );
  }

  @Test
  @DisplayName("시도 횟수 입력 안내 메시지를 출력한다.")
  void 시도_횟수_입력_안내_메시지_출력() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    OutputView.printGameCountPrompt();

    assertEquals(
        "시도할 횟수는 몇 회인가요?" + System.lineSeparator(),
        outContent.toString()
    );
  }
}
