package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 한_라운드_출력_테스트() {
        OutputView.printRoundResult(List.of("pobi : -", "woni : --"));
        Assertions.assertThat(outputStream.toString()).contains("\npobi : -\nwoni : --");
    }
}
