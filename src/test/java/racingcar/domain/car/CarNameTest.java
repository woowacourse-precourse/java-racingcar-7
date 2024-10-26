package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    CarName userCarName;

    @Test
    @DisplayName("사용자가 정상적인 자동차 이름을 입력했을 경우 예외가 발생하지 않는다.")
    public void 정상적인_자동차_이름을_입력했을_경우() {
        //given
        String name = "povi";
        userCarName = new CarName(name);

        //when
        String carName = userCarName.getName();

        //then
        assertThat(carName).isEqualTo(userCarName.getName());
    }

    @Test
    @DisplayName("사용자가 자동차의 이름의 길이가 5글자가 초과될 경우 예외가 발생한다.")
    public void 유효하지_않은_자동차_이름을_입력했을_경우() {
        //given
        String name = "povieeee";

        //then when
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}