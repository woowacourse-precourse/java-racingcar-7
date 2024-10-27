package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;

class ViewTest {

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();

  @Test
  @DisplayName("자동차 이름과 시도 횟수 입력을 정상적으로 받는다.")
  void 자동차_이름_과_시도_횟수_입력_정상_수신() {
    // Given
    System.setIn(new ByteArrayInputStream("pobi, jun, car1\n5\n".getBytes()));

    // When
    String carNames = inputView.getCarNames();
    String tryCount = inputView.getGameCount();

    // Then
    assertEquals("pobi, jun, car1", carNames);
    assertEquals("5", tryCount);
  }

  @Test
  @DisplayName("게임 시작 메시지를 출력한다.")
  void 게임_시작_메시지_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // When
    outputView.printGameStartMessage();

    // Then
    assertEquals("\n실행 결과\n", outContent.toString());
  }

  @Test
  @DisplayName("자동차 이동 결과를 올바르게 출력한다.")
  void 자동차_이동_결과_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    List<CarStatusDTO> carStatuses = List.of(
        new CarStatusDTO("pobi", 2),
        new CarStatusDTO("woni", 3),
        new CarStatusDTO("jun", 4)
    );

    // When
    outputView.printCarPositions(carStatuses);

    // Then
    String expectedOutput =
        "pobi : --\n" +
            "woni : ---\n" +
            "jun : ----\n\n";
    assertEquals(expectedOutput, outContent.toString());
  }


  @Test
  @DisplayName("최종 우승자를 올바르게 출력한다.")
  void 최종_우승자_출력() {
    // Given
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    List<String> winners = List.of("pobi", "jun");

    // When
    outputView.printWinners(winners);

    // Then
    assertEquals("최종 우승자 : pobi, jun\n", outContent.toString());

    System.setOut(System.out);
  }
}
