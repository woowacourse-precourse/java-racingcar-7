package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입출력 테스트")
class IoTest extends NsTest {
    private InputView inputView;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    @Test
    @DisplayName("자동차 이름을 입력받는다")
    void carNamesInput() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun");
            assertThat(inputView.receiveCarNames()).isEqualTo("pobi,woni,jun");
        });
    }

    @Test
    @DisplayName("시도할 횟수를 입력받는다")
    void playCountInput() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(inputView.receivePlayCount()).isEqualTo("5");
        });
    }

    @Test
    @DisplayName("자동차 이름과 1회 움직임 출력을 확인한다")
    void printCarNameAndSingleMove() {
        Car pobi = Car.createDefaultCar("pobi");
        Car jun = Car.createDefaultCar("jun");
        jun.setPosition(1);
        outputView.printSingleResult(pobi);
        outputView.printSingleResult(jun);
        assertThat(output()).contains("pobi :");
        assertThat(output()).contains("jun : -");
    }

    @Test
    @DisplayName("단독 우승자를 출력한다")
    void printSingleWinners() {
        outputView.printWinners(List.of("jun"));
        assertThat(output()).isEqualTo("최종 우승자 : jun");
    }

    @Test
    @DisplayName("공동 우승자를 출력한다")
    void printMultiWinners() {
        outputView.printWinners(List.of("pobi", "jun"));
        assertThat(output()).isEqualTo("최종 우승자 : pobi, jun");
    }

    @Override
    protected void runMain() {

    }
}