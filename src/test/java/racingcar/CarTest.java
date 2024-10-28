package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

class CarTest extends NsTest {

    @Test
    void 자동차가_앞으로_한칸_이동한다() {
        assertSimpleTest(() -> {
                    Car car = new Car("car");
                    car.move(1);
                    assertThat(car.getPosition()).isEqualTo(1);
                }
        );
    }

    @Test
    void 자동차_이름은_5글자_이하여야_한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                Car car = new Car("carrrr");
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
