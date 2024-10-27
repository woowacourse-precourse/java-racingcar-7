package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.RacingCarView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차_입력_테스트() {
        // 가상 입력 스트림 설정
        String input = "pobi,woni\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingCarView racingCarView = new RacingCarView();
        List<String> carNames = racingCarView.getCarInput();


        List<Car> cars = carNames.stream().map(Car::new).toList();

        assertThat("pobi").isEqualTo(cars.get(0).getName());
        assertThat("woni").isEqualTo(cars.get(1).getName());
    }

    @Test
    void 예외_자동차_입력_5자_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5글자 이하만 가능합니다.")
        );
    }

    @Test
    void 예외_자동차_입력_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,pobi", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 중복될 수 없습니다")
        );
    }

    @Test
    void 예외_시도_횟수_0번_이하_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 한 번 이상 시도해야 합니다.")
        );
    }
}
