package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RacingCarInfoMsg.TYPE_CAR_NAMES;
import static racingcar.constant.RacingCarInfoMsg.TYPE_RACE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest extends NsTest {

    private final InputStream standardIn = System.in;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        System.setIn(standardIn);
    }

    @AfterAll
    static void cleanUp() {
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();
    }

    @Test
    @DisplayName("사용자로부터 자동차들의 이름을 입력받을 수 있게 안내 문구가 출력된다")
    void t001() {
        String input = "test";
        setInput(input);

        inputView.inputCarNames();

        assertThat(output()).contains(TYPE_CAR_NAMES.getMsg());
    }

    @Test
    @DisplayName("사용자로부터 자동차의 이름을 입력받는다")
    void t002() {
        String input = "test";
        setInput(input);

        String result = inputView.inputCarNames();

        assertThat(result).isEqualTo("test");
    }

    @Test
    @DisplayName("경주 진행 횟수의 입력을 받을 수 있게 안내 문구가 출력된다.")
    void t003() {
        String input = "4";
        setInput(input);

        inputView.inputRaceCount();

        assertThat(output()).contains(TYPE_RACE_COUNT.getMsg());
    }

    @Test
    @DisplayName("사용자로부터 경주 진행 횟수를 입력받는다")
    void t004() {
        String input = "4";
        setInput(input);

        String result = inputView.inputRaceCount();

        assertThat(result).isEqualTo(input);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}