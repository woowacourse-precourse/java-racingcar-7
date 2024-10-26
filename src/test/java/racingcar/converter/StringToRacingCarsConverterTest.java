package racingcar.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringToRacingCarsConverterTest {

    StringToRacingCarsConverter converter;

    @BeforeEach
    void before() {
        converter = new StringToRacingCarsConverter();
    }

    @Test
    void TDD_경주_자동차_2대_이상_성공() {
        //given
        String input = "pobi,woni";

        //when
        LinkedHashSet<RacingCar> cars = converter.convert(input);

        //then
        assertThat(cars).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void TDD_경주_자동차_2대_이상_조건_실패() {
        //given
        String input = "pobi,    ";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_자동차_이름_중복_미허용_실패() {
        //given
        String input = "pobi,pobi,pobi";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
