package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class CarTest {
    private final static String NAME = "gina";

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(NAME);
    }

    @Test
    public void 자동차_생성() {
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    public void 자동차_생성_이름() {
        assertThat(car.getName()).isEqualTo(NAME);
    }

    @Test
    public void 자동차_초기_거리_0() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차_이동_1회() {
        car.move();
        assertThat(car.getDistance()).isBetween(0, 1);
    }

    @Test
    public void 자동차_이동_2회() {
        car.move();
        car.move();
        assertThat(car.getDistance()).isBetween(0, 2);
    }

    @Test
    public void 자동차_정보_조회() {
        car.move();

        String result = String.join("", NAME, Constants.COLON);
        assertThat(car.getRaceInfo()).contains(result);
    }
}
