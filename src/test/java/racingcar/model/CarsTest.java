package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private static final int ADVANCE_NUMBER = 9;
    private static final int STOP_NUMBER = 0;

    private Car car1;
    private Car car2;
    private Cars cars;

    @BeforeEach
    public void set() {
        car1 = new Car("car1");
        car2 = new Car("car2");

        cars = new Cars(List.of(car1, car2));
    }

    @Test
    public void 자동차_이름_기반_생성_테스트() {
        List<String> carNames = List.of("sean", "cool");
        assertThat(Cars.createCars(carNames))
                .isInstanceOf(Cars.class);
    }

    @Test
    public void 자동차_현황_목록_테스트() {
        car1.race(ADVANCE_NUMBER);
        car2.race(STOP_NUMBER);

        assertThat(cars.getCarsInformation())
                .isEqualTo(List.of("car1 : -", "car2 : "));
    }

    @Test
    public void 단독_우승자_선정_테스트() {
        car1.race(ADVANCE_NUMBER);
        car2.race(STOP_NUMBER);

        assertThat(cars.determineWinners())
                .isEqualTo(List.of("car1"));
    }

    @Test
    public void 복수_우승자_선정_테스트() {
        car1.race(ADVANCE_NUMBER);
        car2.race(ADVANCE_NUMBER);

        assertThat(cars.determineWinners())
                .isEqualTo(List.of("car1", "car2"));
    }
}