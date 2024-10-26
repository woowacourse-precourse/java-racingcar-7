package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceCarTest {

    @Test
    void 자동차_이동_테스트(){
        RaceCar raceCar = RaceCar.fromName("car");
        raceCar.move();

        Assertions.assertThat(raceCar.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 자동차_이름_길이(String carName) {
        assertThatThrownBy(() -> RaceCar.fromName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
