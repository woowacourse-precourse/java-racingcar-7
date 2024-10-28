package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.message.RoundMessage.ROUND_START_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingGame;

class RoundViewTest {

    private final RacingGame racingGame = new RacingGame("pobi,woni,jun");
    private final RoundView roundView = new RoundView(racingGame);
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        // 출력 스트림을 가로채기 위해 출력 스트림을 원하는 타입의 객체로 설정
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("RoundView_생성_테스트")
    @Test
    public void newRoundView() {
        //given
        //when
        //then
        assertThat(roundView).isNotNull();
    }

    @DisplayName("차수별_결과_출력_테스트")
    @Test
    public void printRoundTest() {
        //given
        String expectedView = """
                pobi : -
                woni :\s
                jun : -
                
                """;
        //when
        racingGame.racing(List.of(4, 0, 4));
        roundView.printRound();
        String printResult = outputMessage.toString();
        //then
        assertThat(printResult).isEqualTo(expectedView);
    }

    @DisplayName("2시도_결과_출력_테스트")
    @Test
    public void printTwoRoundTest() {
        //given
        String expectedView = """
                pobi : -
                woni :\s
                jun : -
                
                pobi : --
                woni : -
                jun : --
                
                """;
        //when
        racingGame.racing(List.of(4, 0, 4));
        roundView.printRound();
        racingGame.racing(List.of(4, 4, 4));
        roundView.printRound();
        String printResult = outputMessage.toString();
        //then
        assertThat(printResult).isEqualTo(expectedView);
    }

    @DisplayName("라운드_시작_메세지_출력_테스트")
    @Test
    public void printStartMessageTest() {
        //given
        //when
        roundView.printStartMessage();
        String printResult = outputMessage.toString();
        //then
        assertThat(printResult).isEqualTo(ROUND_START_MESSAGE.getMessage() + "\n");
    }

    @DisplayName("2시도_전체_View_출력_테스트")
    @Test
    public void printWholeTwoRoundTest() {
        //given
        String expectedView = "실행 결과\n"
                + "pobi : -\n"
                + "woni : \n"
                + "jun : -\n"
                + "\n"
                + "pobi : --\n"
                + "woni : -\n"
                + "jun : --\n"
                + "\n";
        //when
        racingGame.racing(List.of(4, 0, 4));
        roundView.printView();
        racingGame.racing(List.of(4, 4, 4));
        roundView.printView();
        String printResult = outputMessage.toString();
        //then
        assertThat(printResult).isEqualTo(expectedView);
    }
}