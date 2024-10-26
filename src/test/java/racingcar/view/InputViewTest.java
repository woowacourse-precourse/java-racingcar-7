package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    void 자동차_입력_프롬프트_출력() {
        setInputStream("pobi,woni,jun");

        InputView.readCarNames();

        assertThat(outputStream.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    void 자동차_입력_테스트() {
        String input = "pobi,woni,jun";
        setInputStream(input);

        ArrayList<String> carNames = InputView.readCarNames();

        assertThat(carNames).isEqualTo(List.of("pobi","woni","jun"));
    }


    void setInputStream(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
