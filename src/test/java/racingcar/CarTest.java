package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class CarTest extends NsTest {

    @Test
    void 전진_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("junki", new Num4Generator());
            assertThat(car.getPosition()).equals(1);
        });
    }

    @Test
    void 정지_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("junki", new Num0Generator());
            assertThat(car.getPosition()).equals(0);
        });
    }

    @Test
    void 이름에_특수문자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java@", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
