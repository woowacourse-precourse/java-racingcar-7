package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class InputViewTest {
    private final static String NAMES = "hana,min,aria";
    private final static String COUNT = "5";

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void consoleClose() {
        Console.close();
    }

    @Test
    public void 이름_입력() {
        System.setIn(new ByteArrayInputStream(NAMES.getBytes()));

        assertThat(inputView.getInputNames()).isEqualTo(NAMES);
    }

    @Test
    public void 이름_입력_메시지_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new ByteArrayInputStream(NAMES.getBytes()));
        inputView.getInputNames();

        assertThat(outputStream.toString().trim()).isEqualTo(Constants.INPUT_NAME_MESSAGE);
    }

    @Test
    public void 반복횟수_입력() {
        System.setIn(new ByteArrayInputStream(COUNT.getBytes()));

        assertThat(inputView.getInputCount()).isEqualTo(COUNT);
    }

    @Test
    public void 반복횟수_입력_메시지_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new ByteArrayInputStream(COUNT.getBytes()));
        inputView.getInputCount();

        assertThat(outputStream.toString().trim()).isEqualTo(Constants.INPUT_COUNT_MESSAGE);
    }
}
