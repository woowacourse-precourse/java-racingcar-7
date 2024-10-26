package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차 이름을 분리하여 자동차 객체 생성")
    @Test
    void 자동차_분리() {
        Cars cars = new Cars("pobi,woni,jun");
        assertThat(cars).isEqualTo(new Cars(new String[]{"pobi", "woni", "jun"}));
    }

    @DisplayName("최대이동거리 구하기")
    @Test
    void 최대이동거리_구하기() {
        Cars cars = new Cars(Arrays.asList(new Car("pobi", new Distance(5))
                , new Car("woni", new Distance(5)),
                new Car("jun", new Distance(4))));
        assertThat(cars.getMaxDistance()).isEqualTo(5);
    }

    @DisplayName("우승자 구하기")
    @Test
    void 우승자_구하기() {
        Cars cars = new Cars(Arrays.asList(new Car("pobi", new Distance(5))
                , new Car("woni", new Distance(5)),
                new Car("jun", new Distance(4))));
        assertThat(cars.getWinnerCars(5)).isEqualTo(new WinnerCars(Arrays.asList(new Car("pobi", new Distance(5))
                , new Car("woni", new Distance(5)))));
    }
}
