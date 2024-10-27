package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차들의 이름을 쉼표로 구분하여 각 자동차 객체를 생성할 수 있습니다.")
    void 자동차들의_이름을_쉼표로_구분하여_각_자동차_객체를_생성할_수_있습니다() {
        //given
        String names = "pobi,woni,jun";

        //when
        Controller controller = new Controller(new InputView(), new OutputView());
        List<Car> cars = controller.initializeGame(names);

        //then
        assertEquals("pobi", cars.getFirst().getName());
        assertEquals("woni", cars.get(1).getName());
        assertEquals("jun", cars.get(2).getName());

    }

    @Test
    @DisplayName("입력한 시도할 횟수가 정수가 아니라면 예외가 발생합니다.")
    void 입력한_시도할_횟수가_정수가_아니라면_예외가_발생합니다() {
        //given
        InputView inputView = new InputView();

        //when
        //then
        assertThatThrownBy(() -> inputView.validateNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 정수여야 합니다.");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
