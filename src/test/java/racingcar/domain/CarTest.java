package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("쉼표를 기준으로 자동차 이름을 분리하여 저장한다.")
    void saveCarName() {
        // given
        String input = "pobi,woni,jun";

        // when
        Car car = new Car(input);

        // then
        assertThat(car.getCars()).contains("pobi", "woni", "jun");
    }

}