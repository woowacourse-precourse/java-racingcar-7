package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.message.InputRequestMessage.NAMES_REQUEST_MESSAGE;
import static racingcar.message.InputRequestMessage.NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
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
    private InputView inputView;

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

    void setUpInputView(boolean isNameInputViewTest) {
        if (isNameInputViewTest) {
            inputView = new NameInputView();
        }

        if (!isNameInputViewTest) {
            inputView = new AttemptsInputView();
        }
    }

    @DisplayName("AttemptsInputView_생성_테스트")
    @Test
    public void newAttemptsInputViewTest() {
        //given
        //when
        inputView = new AttemptsInputView();
        //then
        assertThat(inputView).isNotNull();
    }

    @DisplayName("NameInputView_생성_테스트")
    @Test
    public void newNameInputViewTest() {
        //given
        //when
        inputView = new NameInputView();
        //then
        assertThat(inputView).isNotNull();
    }

    @DisplayName("이름_입력_요청_메세지_출력_테스트")
    @Test
    public void printCarNamesRequestTest() {
        //given
        setUpInputView(true);
        //when
        inputView.printRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertThat(printResult).isEqualTo(NAMES_REQUEST_MESSAGE.getMessage());
    }

    @DisplayName("이름_문자열_입력_테스트")
    @Test
    public void getCarNamesTest() {
        //given
        setUpInputView(true);
        String input = "pobi,woni,jun";
        //when
        Console.close();
        setInputStreamsByMyInput(input);
        String names = inputView.getInput();
        //then
        assertThat(names).isEqualTo(input);
    }

    @DisplayName("시도횟수_입력_요청_메세지_출력_테스트")
    @Test
    public void printNumberOfAttemptsRequestTest() {
        //given
        setUpInputView(false);
        //when
        inputView.printRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertThat(printResult).isEqualTo(NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE.getMessage());
    }

    @DisplayName("시도횟수_입력_테스트")
    @Test
    public void getNumberOfAttemptsTest() {
        //given
        String input = "5";
        setUpInputView(false);
        //when
        Console.close();
        setInputStreamsByMyInput(input);
        String attempts = inputView.getInput();
        //then
        assertThat(attempts).isEqualTo(input);
    }
}