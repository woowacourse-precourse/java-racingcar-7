package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private Application application;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 최종_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    // 자동차 이름과 시도할 횟수를 입력
                    run("pobi,woni", "5");
                    // 출력 결과 검증
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

    @BeforeEach
    public void setUp() {
        application = new Application();
        application.list = new Car[]{
                new Car("car1", false, new StringBuffer("")),
                new Car("car2", false, new StringBuffer(""))
        };
    }

    @Test
    void add_전진_테스트() {
        // true 일 경우 전진 하는 것
        application.list[0] = new Car("car1", true, new StringBuffer("-"));
        application.list[1] = new Car("car2", true, new StringBuffer(""));
        assertThat(application.list[0].getRacer_point().toString()).isEqualTo("--");
        assertThat(application.list[1].getRacer_point().toString()).isEqualTo("-");

    }

    @Test
    void add_모두_멈춤_테스트() {
        // false 일 경우 전진 하는 것
        application.list[0] = new Car("car1", false, new StringBuffer("--"));
        application.list[1] = new Car("car2", false, new StringBuffer("-"));
        assertThat(application.list[0].getRacer_point().toString()).isEqualTo("--");
        assertThat(application.list[1].getRacer_point().toString()).isEqualTo("-");
    }
}
