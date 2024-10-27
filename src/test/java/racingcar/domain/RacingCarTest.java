package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("이름을 갖는 자동차를 생성할 수 있다.")
    public void createRacingCarWithName() {
        String name = "이름";
        RacingCar racingCar = new RacingCar(name);

        String racingCarName = racingCar.getName();

        assertThat(racingCarName).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차는 5자를 초과하는 이름을 가질 수 없다.")
    public void racingCarCannotHaveNameOver5Length() {
        String name = "여섯자리이름";

        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
