package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest extends NsTest {
    private InputHandler inputHandler;

    @BeforeEach
    public void setUp() {
        inputHandler = new InputHandler();
    }

    @Test
    void 입력_리스트_변환() {
        String inputData = "Alice,Bob,Char";

        assertThat(inputHandler.getNames(inputData)).containsExactly("Alice", "Bob", "Char");
    }

    @Test
    void 공백_입력_시_예외() {
        String inputData = ", ,Char";

        assertThatThrownBy(() -> inputHandler.getNames(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_5이상_예외() {
        String inputData = "Charlie,bob";

        assertThatThrownBy(() -> inputHandler.getNames(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_횟수_변환() {
        String inputData = "6";

        assertThat(inputHandler.getCount(inputData)).isEqualTo(6);
    }

    @Test
    void 횟수_음수_예외() {
        String inputData = "-1";

        assertThatThrownBy(() -> inputHandler.getCount(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_문자_예외() {
        String inputData = "s";

        assertThatThrownBy(() -> inputHandler.getCount(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
