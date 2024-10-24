package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    Name userName;

    @Test
    @DisplayName("사용자가 정상적인 자동차 이름을 입력했을 경우 예외가 발생하지 않는다.")
    public void 정상적인_자동차_이름을_입력했을_경우() {
        //given
        String name = "povi";
        userName = new Name(name);

        //when
        String carName = userName.getName();

        //then
        assertThat(carName).isEqualTo(userName.getName());
    }

    @Test
    @DisplayName("사용자가 자동차의 이름의 길이가 5글자가 초과될 경우 예외가 발생한다.")
    public void 유효하지_않은_자동차_이름을_입력했을_경우() {
        //given
        String name = "povieeee";

        //then when
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}