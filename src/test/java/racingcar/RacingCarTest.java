package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest extends NsTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    void 쉼표로_시작하는_데이터_값을_받은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,pi","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    void 쉼표가_중복되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,pi","1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    void 중복된_자동차_이름이_참여할_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다")
    void 시도할_횟수가_양수가_아닐_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
