package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.TestConstants.CAR_NAME_JUN;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_WONI;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("자동차 이름들을 넣을 경우 자동차들이 잘 생성된다.")
    void createCars () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.size()).isEqualTo(carNames.size());
    }
}