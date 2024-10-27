package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 입력된_자동차_이름_문자열_쉼표로_구분() {
        //given
        String carNameInput = "car1,car2,car3";
        String rounds = "2";

        //when
        Game game = new Game(carNameInput, rounds);
        List<Car> cars = game.getCars();

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("car1");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("car2");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("car3");
    }
}