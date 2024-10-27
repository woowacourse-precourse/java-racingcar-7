package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;

class InputViewTest extends NsTest {
    private InputView inputView = new InputView();

    @Test
    void getCarNames_정상_입력_테스트() {
        Assertions.assertSimpleTest(() -> {
            run("pobi,woni,jun");
            String carNames = inputView.getCarNames();
            assertThat(carNames).isEqualTo("pobi,woni,jun");
        });
    }

    @Test
    void getNumberOfTurn_정상_입력_테스트() {
        Assertions.assertSimpleTest(() -> {
            run("3");
            int numberOfTurn = inputView.getNumberOfTurn();
            assertThat(numberOfTurn).isEqualTo(3);
        });
    }

    @Test
    void 이름_입력_예외_테스트() {
        Assertions.assertSimpleTest(() -> {
            ArrayList<String> carNamesWithEmpty = new ArrayList<>();
            carNamesWithEmpty.add("pobi");
            carNamesWithEmpty.add("");
            carNamesWithEmpty.add("woni");

            assertThatThrownBy(() -> inputView.validateCarNames(carNamesWithEmpty))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 빈 문자열이 있습니다.");
        });

        Assertions.assertSimpleTest(() -> {
            ArrayList<String> longCarNames = new ArrayList<>();
            longCarNames.add("toolongname");

            assertThatThrownBy(() -> inputView.validateCarNames(longCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("CarName이 5자 이상입니다.");
        });
    }

    @Test
    void 횟수_입력_예외_테스트() {
        Assertions.assertSimpleTest(() -> {
            run("abc"); // 숫자가 아닌 입력
            assertThatThrownBy(() -> inputView.getNumberOfTurn())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 횟수는 숫자여야 합니다.");
        });

        Assertions.assertSimpleTest(() -> {
            run("0"); // 1 미만의 입력
            assertThatThrownBy(() -> inputView.getNumberOfTurn())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 횟수는 1 이상이여야 합니다.");
        });
    }

    @Override
    public void runMain() {
        // 필요하지 않으므로 구현을 생략합니다.
    }
}
