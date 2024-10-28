package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputView inputView = new InputView();
    private InputStream inputStream;

    @AfterEach
    public void resetStream() {
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 자동차_이름이_공백이면_예외처리() {
        String input = "\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.inputCarName())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_입력시_숫자가_아니라면_예외_처리() {
        String input = "세번";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.inputRacingTurn())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_양의_정수가_아니라면_예외_처리() {
        String input = "0";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.inputRacingTurn())
                .isInstanceOf(IllegalArgumentException.class);
    }
}