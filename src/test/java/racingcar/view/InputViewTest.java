package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.ExceptionMessage.CAR_MOVEMENT_COUNT_EMPTY_EXCEPTION;
import static racingcar.ExceptionMessage.CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력_안내_문구_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        inputView.printCarNameInputGuide();

        assertThat(outputStream.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 자동차_이름_입력() {
        String input = "poby,woni";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = inputView.getCarNameInput();

        assertThat(result).isEqualTo(input);
    }

    @Test
    void 자동차_이동_횟수_입력_안내_문구_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        inputView.printCarMovementCountInputGuide();

        assertThat(outputStream.toString().trim())
                .isEqualTo("시도할 횟수는 몇 회인가요?");
    }

    @Test
    void 자동차_이동_횟수_입력() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        long result = inputView.getCarMovementCount();

        assertThat(result).isEqualTo(5L);
    }

    @Test
    void 자동차_이동_횟수가_공백이면_예외() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() ->
                inputView.getCarMovementCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_MOVEMENT_COUNT_EMPTY_EXCEPTION.message());
    }

    @Test
    void 자동차_이동_횟수가_자연수가_아니면_예외() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() ->
                inputView.getCarMovementCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION.message());
    }
}
