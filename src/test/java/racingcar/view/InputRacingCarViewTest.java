package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    public void input(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    public ByteArrayOutputStream output() {
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
    public void init(){
        Console.close();
    }

    @Test
    public void 자동차_이름_입력_문자열_테스트() {
        assertSimpleTest(() -> {
            // given
            String inputString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
            ByteArrayOutputStream output = output();
            input("창의");

            // when
            inputRacingCarView.inputCarName();

            // then
            assertThat(output.toString()).contains(inputString);
        });
    }

    @Test
    public void 자동차_이름_입력_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "창의, 상현, 지후";
            input(input);

            // when
            String result = inputRacingCarView.inputCarName();

            // then
            assertThat(result).isEqualTo(input);
        });
    }

    @Test
    public void 자동차_이동횟수_입력_문자열_테스트() {
        assertSimpleTest(() -> {
            // given
            String inputString = "시도할 횟수는 몇 회인가요?";
            ByteArrayOutputStream output = output();
            input("창의");

            // when
            inputRacingCarView.inputCarMoveCount();

            // then
            assertThat(output.toString()).contains(inputString);
        });
    }

    @Test
    public void 자동차_이동횟수_입력_테스트() {
        assertSimpleTest(() -> {
            // given
            String input = "3";
            input(input);

            // when
            String result = inputRacingCarView.inputCarMoveCount();

            // then
            assertThat(result).isEqualTo(input);
        });
    }
}
