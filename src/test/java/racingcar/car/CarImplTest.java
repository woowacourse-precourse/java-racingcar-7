package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarImplTest {

    @Test
    @DisplayName("자동차는 이름을 가진다")
    void 자동차_이름_가짐_TEST(){
        String name = "sumin";
        CarImpl car = new CarImpl(name);

        Assertions.assertThat(car.getCarName()).isEqualTo(name);
    }

}