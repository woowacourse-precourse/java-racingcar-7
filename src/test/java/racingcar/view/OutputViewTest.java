package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
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
    void 실행_결과_출력_테스트() {
        OutputView.printResultMessage();

        assertThat(outputStream.toString()).contains("실행 결과");
    }

    @Test
    void 한_라운드_출력_테스트() {
        OutputView.printRoundResult(List.of("도현 : -", "현도 : --", "꼴지 : "));

        assertThat(outputStream.toString()).contains("도현 : -\n현도 : --\n꼴지 : ");
    }

    @Test
    void 단독_우승_결과_출력_테스트() {
        OutputView.printWinningCars(List.of("도현"));

        assertThat(outputStream.toString()).contains("최종 우승자 : 도현");
    }

    @Test
    void 공동_우승_결과_출력_테스트() {
        OutputView.printWinningCars(List.of("도현", "현도"));

        assertThat(outputStream.toString()).contains("최종 우승자 : 도현, 현도");
    }
}
