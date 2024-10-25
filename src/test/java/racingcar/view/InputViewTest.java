package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static racingcar.message.InputRequestMessage.NAMES_REQUEST;
import static racingcar.message.InputRequestMessage.NUMBER_OF_ATTEMPT_REQUEST;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        // 출력 스트림을 가로채기 위해 출력 스트림을 원하는 타입의 객체로 설정
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    void setInputStreamsByMyInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("InputView_생성_테스트")
    @Test
    public void newInputViewTest() {
        //given
        InputView inputView = new InputView();
        //when

        //then
        assertNotNull(inputView);
    }

    @DisplayName("이름_입력_요청_메세지_출력_테스트")
    @Test
    public void printCarNamesRequestTest() {
        //given
        InputView inputView = new InputView();
        //when
        inputView.printCarNamesRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertEquals(NAMES_REQUEST.getMessage(), printResult);
    }

    @DisplayName("이름_문자열_입력_테스트")
    @Test
    public void getCarNamesTest() {
        //given
        InputView inputView = new InputView();
        String input = "pobi,woni,jun";
        //when
        setInputStreamsByMyInput(input);
        String names = inputView.getCarNames();
        //then
        assertEquals(input, names);
    }

    @DisplayName("시도횟수_입력_요청_메세지_출력_테스트")
    @Test
    public void printNumberOfAttemptRequestTest() {
        //given
        InputView inputView = new InputView();
        //when
        inputView.printNumberOfAttemptRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertEquals(NUMBER_OF_ATTEMPT_REQUEST.getMessage(), printResult);
    }
}