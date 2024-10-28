package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @BeforeEach
    void 콘솔_닫기() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력() {
        String inputCarNames = "pobi,nana,jun";
        System.setIn(new ByteArrayInputStream(inputCarNames.getBytes()));

        String carNames = InputView.inputCarNames();

        assertThat(carNames).isEqualTo("pobi,nana,jun");
    }

    @Test
    void 시도_횟수_입력() {
        String inputTryCount = "5";
        System.setIn(new ByteArrayInputStream(inputTryCount.getBytes()));

        String tryCount = InputView.inputTryCount();

        assertThat(tryCount).isEqualTo("5");
    }
}
