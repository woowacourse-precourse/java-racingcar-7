package racingcar.input.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputToRacingCarsConverterTest {

    InputToRacingCarsConverter inputToRacingCarsConverter;

    @BeforeEach
    void before() {
        inputToRacingCarsConverter = new InputToRacingCarsConverter();
    }

    @Test
    void TDD_경주_자동차_2대_이상_성공() {
        //given
        String input = "pobi,woni";

        //when
        LinkedList<RacingCar> racingCars = inputToRacingCarsConverter.convert(input);

        //then
        assertThat(racingCars).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void TDD_경주_자동차_2대_이상_조건_실패() {
        //given
        String input = "pobi";

        //when
        assertThatThrownBy(() -> inputToRacingCarsConverter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
