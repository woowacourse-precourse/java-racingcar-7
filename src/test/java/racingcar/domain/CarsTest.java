package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 자동차_리스트에_들어가있는지_테스트() {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();
        Cars cars = new Cars("hello,I'm,bo,wook,^^", carNameValidator);

        //when
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList.size()).isEqualTo(5);
        assertThat(carList.get(0).getCarName()).isEqualTo("hello");
        assertThat(carList.get(1).getCarName()).isEqualTo("I'm");
        assertThat(carList.get(2).getCarName()).isEqualTo("bo");
        assertThat(carList.get(3).getCarName()).isEqualTo("wook");
        assertThat(carList.get(4).getCarName()).isEqualTo("^^");
    }
}
