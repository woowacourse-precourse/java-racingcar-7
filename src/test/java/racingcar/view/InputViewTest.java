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
    private final InputView inputView = new InputView();

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
        //when
        //then
        assertThat(inputView).isNotNull();
    }

    @DisplayName("이름_입력_요청_메세지_출력_테스트")
    @Test
    public void printCarNamesRequestTest() {
        //given
        //when
        inputView.printCarNamesRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertThat(printResult).isEqualTo(NAMES_REQUEST_MESSAGE.getMessage());
    }

    @DisplayName("이름_문자열_입력_테스트")
    @Test
    public void getCarNamesTest() {
        //given
        String input = "pobi,woni,jun";
        //when
        Console.close();
        setInputStreamsByMyInput(input);
        String names = inputView.getCarNames();
        //then
        assertThat(names).isEqualTo(input);
    }

    @DisplayName("시도횟수_입력_요청_메세지_출력_테스트")
    @Test
    public void printNumberOfAttemptsRequestTest() {
        //given
        //when
        inputView.printNumberOfAttemptsRequest();
        String printResult = outputMessage.toString().trim();
        //then
        assertThat(printResult).isEqualTo(NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE.getMessage());
    }

    @DisplayName("시도횟수_입력_테스트")
    @Test
    public void getNumberOfAttemptsTest() {
        //given
        String input = "5";
        //when
        Console.close();
        setInputStreamsByMyInput(input);
        String attempts = inputView.getNumberOfAttempts();
        //then
        assertThat(attempts).isEqualTo(input);
    }
}