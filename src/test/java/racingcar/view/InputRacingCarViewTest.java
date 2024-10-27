package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputRacingCarViewTest {
    private final InputRacingCarView inputRacingCarView;

    public InputRacingCarViewTest() {
        this.inputRacingCarView = new InputRacingCarView();
    }

    private void input(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    private ByteArrayOutputStream output() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    @AfterEach
    public void initInputAndOutput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @BeforeEach
    public void init() {
        Console.close();
    }


    @Test
    public void 자동차_이름_입력_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "창의, 상현, 지후";
            input(input);

            // when
            String result = inputRacingCarView.getInputText();

            // then
            assertThat(result).isEqualTo(input);
        });
    }


    @Test
    public void 자동차_이동횟수_입력_테스트() {
        assertSimpleTest(() -> {
            // given
            int input = 3;
            input(String.valueOf(input));

            // when
            int result = inputRacingCarView.getInputNumber();

            // then
            assertThat(result).isEqualTo(input);
        });
    }

    @Test
    public void 자동차_숫자가아닌_이동횟수_입력_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "xxx";
            input(input);

            // when
            assertThatThrownBy(() -> inputRacingCarView.getInputNumber())
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
