package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarTest extends NsTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("MyCar");
    }

    @Test
    void 자동차가_앞으로_한칸_이동한다() {
        assertSimpleTest(() -> {
                    car.move(1);
                    assertThat(car.getPosition()).isEqualTo(1);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
