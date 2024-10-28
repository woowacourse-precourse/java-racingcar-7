package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarListTest {

    @Test
    @DisplayName("from 메소드 정상 테스트")
    void splitTest() {
        String input = "car1,car2,car3";

        CarList carList = new CarList();
        for (String name : input.split(",")) {
            carList.add(name);
        }

        CarNameCollect carNameCollect = CarNameCollect.create(input);
        assertThat(CarList.from(carNameCollect)).isEqualTo(carList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni"})
    @DisplayName("차 이름 생성 테스트")
    void test1(String s) {

        CarNameCollect carNameCollect = CarNameCollect.create(s);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CarList.from(carNameCollect));

        assertThat(exception.getMessage()).contains(INVALID_CAR_NAME.getMessage());
    }

}
