package racingcar;

import racingcar.common.io.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class OutputTest {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void 진행상황_출력_테스트() {
    Output outputHandler = new Output();
    outputHandler.printRaceProgress("hsj", 3);

    assertThat(outputStream.toString().trim()).isEqualTo("hsj : ---");
  }

  @Test
  void 우승자_출력_테스트() {
    Output outputHandler = new Output();
    outputHandler.printWinners(List.of("hsj"));

    assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : hsj");
  }

  @Test
  void 공동_우승자_출력_테스트() {
    Output outputHandler = new Output();
    outputHandler.printWinners(Arrays.asList("jsh", "hsj", "jwj"));

    assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : jsh, hsj, jwj");
  }
}
