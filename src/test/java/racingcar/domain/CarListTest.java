package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarListTest {

    @Test
    @DisplayName("from 메소드 정상 테스트")
    void splitTest() {
        String input = "car1,car2,car3";

        CarList carList = new CarList();
        for (String name : input.split(",")) {
            carList.add(name);
        }

        NameCollect nameCollect = NameCollect.create(input);
        assertThat(CarList.from(nameCollect)).isEqualTo(carList);
    }

}
