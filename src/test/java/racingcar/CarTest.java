package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @DisplayName("자동차를 생성한다.")
    @Test
    void createCar() {
        //given
        Car car = Car.from("pobi");
        //when
        //then
        assertThat(car)
            .extracting("name", "position")
            .containsExactlyInAnyOrder("pobi", 0);
    }

    @DisplayName("자동차의 이름은 5글자 이하여야 한다.")
    @Test
    void carNameIsUnderLength() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Car.from("나는여섯글자"))
            .withMessage("이름은 5자 이하여야 합니다.");
    }

}