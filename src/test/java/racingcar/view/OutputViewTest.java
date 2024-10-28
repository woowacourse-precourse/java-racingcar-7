package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        // 출력 스트림을 가로채기 위해 출력 스트림을 원하는 타입의 객체로 설정
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("OutputView_생성_테스트")
    @Test
    public void newOutputView() {
        //given
        //when
        outputView = new OutputView("");
        //then
        assertThat(outputView).isNotNull();
    }

    @DisplayName("우승자_출력_테스트")
    @Test
    public void printWinnersTest() {
        //given
        String winners = "pobi, woni, jun";
        String expectedView = "최종 우승자 : pobi, woni, jun";
        //when
        outputView = new OutputView(winners);
        outputView.printView();
        String printResult = outputMessage.toString().trim();
        //then
        assertThat(printResult).isEqualTo(expectedView);
    }
}