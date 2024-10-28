package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest extends NsTest {
    @Test
    void 자동차_이름_입력() {
        String[] input = {"c","java","node"};
        String inputStr = String.join(",", input);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes()));

        String[] result = InputView.getCarNames();
        assertThat(result).containsExactly("c", "java", "node");
    }

    @Test
    void 자동차_이름_길이_예외_테스트() {
        String input = "java,lloonngg";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        String input = "java,node,java";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

    @Test
    void 이동_횟수_입력() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = InputView.getMovementCount();
        assertThat(result).isEqualTo(5);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}