package racingcar.model.vehicle.car;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.vehicle.car.Cars;

public class CarsTest {

    Cars cars;

    @BeforeEach
    public void setUp() {
        this.cars = new Cars(List.of("gamza, kim, lee"));
    }

    @Test
    @DisplayName("자동차들의 이름 확인 테스트")
    public void checkCarNamesTest(){
        // given
        List<String> names = List.of("gamza", "kim", "lee");

        // when, then
        Assertions.assertThat(names).containsOnly("gamza", "kim", "lee");
    }

    @Test
    @DisplayName("자동차들의 현재 이동한 거리 확인")
    public void checkCarsPosition(){
        // given
        // when
        // then
    }
}
