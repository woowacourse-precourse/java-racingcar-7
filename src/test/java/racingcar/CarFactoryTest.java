package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi,woni,jun,sean,lee"})
    @DisplayName("nameLimitLength 이하인 이름이 주어졌을 때 Car 리스트를 생성한다.")
    void createCarsSuccess(String names) {
        int result = names.split(",").length;
        List<Car> cars = CarFactory.createCars(names, 4, 5);
        Assertions.assertThat(cars).hasSize(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "woniwn", "pobi,woni,junjun"})
    @DisplayName("nameLimitLength보다 긴 이름이 주어졌을 때 에러가 발생한다.")
    void createCarsFail() {
        Assertions.assertThatThrownBy(() -> CarFactory.createCars("pobi,woni,junjun", 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}