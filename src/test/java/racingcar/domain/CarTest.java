package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("쉼표를 기준으로 자동차 이름을 분리하여 저장한다.")
    void saveCarName() {
        // given
        String input = "pobi,woni,jun";

        // when
        Car car = Car.from(input);

        // then
        assertThat(car.getCars()).contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하가 아닌 경우 예외가 발생한다.")
    void carNameLengthValidation() {
        // given
        String input = "pobi,woni,jun,testCarName";

        // when & then
        assertThatThrownBy(() -> Car.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
    
    @Test
    @DisplayName("자동차 이름이 중복된 경우 예외가 발생한다.")
    void duplicateCarNameValidation() {
        // given
        String input = "pobi,woni,jun,pobi";

        // when & then
        assertThatThrownBy(() -> Car.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

}