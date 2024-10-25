package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();

    @Test
    @DisplayName("사용자로부터 자동차들의 이름을 입력받는 문구가 출력된다")
    void t001() {
        //given
        String testInput = "seo";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        //when
        inputView.inputCarNames();

        //then
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("사용자는 자동차들의 이름을 입력할 수 있다")
    void t002() {
        //given
        String testInput = "seo";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        //when
        String result = inputView.inputCarNames();

        //then
        assertThat(result).isEqualTo(testInput);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}