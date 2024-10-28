package racingcar.view.console;

import org.junit.jupiter.api.Test;
import racingcar.dto.CarNamesInput;
import racingcar.dto.TryCountInput;
import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleInputViewTest extends NsTest {

    @Test
    void 자동차_이름을_읽어온다() {
        String input = "포비,우니,동훈";
        run(input);

        CarNamesInput carNamesInput = new ConsoleInputView().readCarNames();
        assertThat(carNamesInput.carNames()).isEqualTo("포비,우니,동훈");
    }

    @Test
    void 시도_횟수를_읽어온다() {
        String input = "5";
        run(input);

        TryCountInput tryCountInput = new ConsoleInputView().readTryCount();
        assertThat(tryCountInput.tryCount()).isEqualTo("5");
    }

    @Override
    protected void runMain() {
    }
}