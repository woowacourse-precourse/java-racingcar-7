package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarManagerTest {

    @Test
    void 읽기_전용_자동차_조회_테스트() {
        List<String> givenCarNames = new ArrayList<>();
        givenCarNames.add("abc");
        givenCarNames.add("qwe");
        CarManager givenCarManager = new CarManager(givenCarNames);
        List<Car> givenCars = givenCarManager.getCars();

        assertAll(
                () -> assertThatThrownBy(() -> givenCars.add(new Car("illegal car"))).isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatThrownBy(() -> givenCars.remove(givenCars.getFirst())).isInstanceOf(UnsupportedOperationException.class)
        );
    }

    @Test
    void 읽기_전용_점수로_자동차_조회_테스트() {
        List<String> givenCarNames = new ArrayList<>();
        givenCarNames.add("abc");
        givenCarNames.add("qwe");
        CarManager givenCarManager = new CarManager(givenCarNames);
        List<Car> givenCars = givenCarManager.getCarsByScore(0);

        assertAll(
                () -> assertThatThrownBy(() -> givenCars.add(new Car("illegal car"))).isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatThrownBy(() -> givenCars.remove(givenCars.getFirst())).isInstanceOf(UnsupportedOperationException.class)
        );
    }
}
