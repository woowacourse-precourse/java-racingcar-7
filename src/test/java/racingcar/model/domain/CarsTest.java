package racingcar.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름으로 Cars 일급 컬렉션을 올바르게 생성하는지 확인하는 테스트")
    void getCarsReadOnly() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        // when
        List<Car> carsReadOnly = cars.getCarsReadOnly();

        // then
        assertThat(carsReadOnly).hasSize(3);
        assertThat(carsReadOnly.get(0).getCarName()).isEqualTo("pobi");
        assertThat(carsReadOnly.get(1).getCarName()).isEqualTo("woni");
        assertThat(carsReadOnly.get(2).getCarName()).isEqualTo("jun");
    }
}