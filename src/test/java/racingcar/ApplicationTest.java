package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
    void 이름에_공백이_들어온_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤_값이_4_이상일_경우_차_이동_테스트() {
        // given
        RandomNumberGenerator fixedNumberGenerator = new FixedNumber5Test();
        Car car = new Car("pobi");
        Cars cars = new Cars(List.of(car));

        // when
        cars.move(fixedNumberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    void 랜덤_값이_4_이하일_경우_차_이동_테스트() {
        // given
        RandomNumberGenerator fixedNumberGenerator = new FixedNumber3Test();
        Car car = new Car("pobi");
        Cars cars = new Cars(List.of(car));

        // when
        cars.move(fixedNumberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 참가자_이름의_길이가_6_이상_인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,ibrahimovic", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수를_입력하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수가_null일_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수를_0을_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수에_음수를_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수에_문자를_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "문자"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자가_1명_일_경우_우승자_출력() {
        // given
        List<String> winner = List.of("pobi");
        // when
        outputView.printWinner(winner);
        // then
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    void 우승자가_여러명_일_경우_우승자_출력() {
        // given
        List<String> winner = List.of("pobi,woni");
        // when
        outputView.printWinner(winner);
        // then
        assertThat(output()).contains("최종 우승자 : pobi,woni");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}