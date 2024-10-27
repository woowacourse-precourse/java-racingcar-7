package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("이름을 갖는 자동차를 생성할 수 있다.")
    public void createRacingCarWithName() {
        String name = "이름";
        RacingCar racingCar = new RacingCar(name);

        String racingCarName = racingCar.getName();

        assertThat(racingCarName).isEqualTo(name);
    }

}
