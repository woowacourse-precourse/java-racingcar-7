package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest extends NsTest {
    private Main main = new Main();

    @Test
    @DisplayName("자동차 이름을 입력받는다")
    void carNamesInput() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun");
            assertThat(main.receiveCarNames()).isEqualTo("pobi,woni,jun");
        });
    }

    @Test
    @DisplayName("쉼표를 기준으로 자동차 이름을 분리한다")
    void splitCarNames() {
        assertThat(main.splitCarNames("pobi,woni,jun")).isEqualTo(new String[]{"pobi","woni","jun"});
    }

    @Test
    @DisplayName("생성할 자동차의 개수를 확인한다")
    void confirmCarCount() {
        assertThat(main.calculateCarCount(new String[]{"pobi","woni","jun"})).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 객체를 생성한다")
    void createSingleCar() {
        assertThat(main.createCar("pobi")).isInstanceOf(Car.class);
    }

    @Override
    protected void runMain() {

    }
}