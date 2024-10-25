package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;

public class ViewTest {

  @Test
  @DisplayName("자동차 이름과 시도 횟수 입력을 정상적으로 받는다.")
  void 자동차_이름_과_시도_횟수_입력_정상_수신() {
    // Given
    System.setIn(new ByteArrayInputStream("pobi, jun, car1\n5\n".getBytes()));

    // When
    String carNames = InputView.getCarNames();
    String tryCount = InputView.getTryCount();

    // Then
    assertEquals("pobi, jun, car1", carNames);
    assertEquals("5", tryCount);
  }

  @Test
  @DisplayName("자동차 이름 입력 안내 메시지를 출력한다.")
  void 자동차_이름_입력_안내_메시지_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // When
    OutputView.printCarNamePrompt();

    // Then
    assertEquals(
        "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator(),
        outContent.toString()
    );
  }

  @Test
  @DisplayName("게임 시작 메시지를 출력한다.")
  void 게임_시작_메시지_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // When
    OutputView.printGameStartMessage();

    // Then
    assertEquals("\n실행 결과\n", outContent.toString());
  }

  @Test
  @DisplayName("자동차 이동 결과를 올바르게 출력한다.")
  void 자동차_이동_결과_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<String> carStatuses = List.of(
        "pobi : --",
        "woni : ---",
        "jun : ----"
    );

    // When
    OutputView.printCarPositions(carStatuses);

    // Then
    String expectedOutput =
        "pobi : --\n" +
            "woni : ---\n" +
            "jun : ----\n\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  @DisplayName("시도 횟수 입력 안내 메시지를 출력한다.")
  void 시도_횟수_입력_안내_메시지_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // When
    OutputView.printGameCountPrompt();

    // Then
    assertEquals(
        "시도할 횟수는 몇 회인가요?" + System.lineSeparator(),
        outContent.toString()
    );
  }
}
