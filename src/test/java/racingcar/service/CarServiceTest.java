package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.RacingcarConfig;
import racingcar.domain.CarList;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;

class CarServiceTest {

    CarService carService = RacingcarConfig.carService();

    @Test
    @DisplayName("process 테스트")
    void test1() {
        // given
        TryCount tryCount = new TryCount(0);
        CarList carList = new CarList();

        carList.add("car1");
        carList.add("car2");
        carList.add("car3");

        Winners expect = Winners.from(carList);

        // when
        Winners result = carService.process(carList, tryCount);

        // then
        assertThat(result).isEqualTo(expect);
    }
}
