package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InitCarsTest {
    @Test
    @DisplayName("자동차 이름 배열을 전달하여 Car 객체 리스트가 제대로 초기화되는지 확인한다")
    void initCarsTest() {
        String[] carNames = {"pobi", "woni", "jun"};
        List<Car> carList = InitCars.initCars(carNames);
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).toString()).isEqualTo("pobi : ");
        assertThat(carList.get(1).toString()).isEqualTo("woni : ");
        assertThat(carList.get(2).toString()).isEqualTo("jun : ");
    }
}