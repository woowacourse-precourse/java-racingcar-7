package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.InputRequestMessage;

class InputViewTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @DisplayName("InputView_생성_테스트")
    @Test
    public void newInputViewTest() {
        //given
        InputView inputView = new InputView();
        //when

        //then
        Assertions.assertNotNull(inputView);
    }

    @DisplayName("입력_요청_메세지_출력_테스트")
    @Test
    public void printInputRequestMessageTest() {
        //given
        InputView inputView = new InputView();
        //when
        inputView.printInputRequestMessage();
        //then
        Assertions.assertEquals(outputMessage.toString().trim(), InputRequestMessage.NAME_REQUEST_MESSAGE.getMessage());
    }

}