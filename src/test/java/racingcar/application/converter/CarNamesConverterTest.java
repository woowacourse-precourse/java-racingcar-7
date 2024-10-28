package racingcar.application.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class CarNamesConverterTest {

    @Test
    public void 쉼표로_구분된_자동차_이름들을_변환할_수_있다() throws Exception {
        //given
        CarNamesConverter converter = new CarNamesConverter();

        //when
        List<Car> result = converter.convert("pobi,woni,jun");

        //then
        assertThat(result).map(Car::getName).containsExactly("pobi", "woni", "jun");
    }
}