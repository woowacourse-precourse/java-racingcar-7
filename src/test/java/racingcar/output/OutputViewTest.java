package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private OutputViewer outputViewer;

    @BeforeEach
    void setUp() {
        this.outputViewer = new OutputViewer();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 경주할_자동차_이름_안내문_출력() {
        outputViewer.getCarNameInputMessage();
        assertThat(outputStreamCaptor.toString())
                .contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도할_횟수_안내문_출력() {
        outputViewer.getTryCountInputMessage();
        assertThat(outputStreamCaptor.toString())
                .contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    void 실행_결과_안내문_출력() {
        outputViewer.getRacingProgressMessage();
        assertThat(outputStreamCaptor.toString())
                .contains("실행 결과");
    }

    @Test
    void 최종_우승자_안내문_출력() {
        outputViewer.getRacingResultMessage("pobi, jun");
        assertThat(outputStreamCaptor.toString())
                .contains("최종 우승자 : pobi, jun");
    }
}
