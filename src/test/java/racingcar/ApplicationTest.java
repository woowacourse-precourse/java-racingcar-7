package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
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
    @Test
    void 이름이_숫자일_때_예외_발생() {
        assertThatThrownBy(() -> {
            Application.validateName(new String[]{"12345", "hello"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 숫자만 입력할 수 없습니다.");
    }
    @Test
    void 공동_우승자_출력() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"));
        cars.get(0).go();
        cars.get(1).go();
        Application.winner(cars);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
