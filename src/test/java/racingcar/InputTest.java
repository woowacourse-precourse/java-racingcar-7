package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.Input;

public class InputTest {
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    void convertToCarTest() {
        //when
        List<String> carNames = List.of("pobi", "woni", "jun");

        //given
        List<Car> carList = input.convertToCar(carNames);

        //then
        assertThat(carList).isEqualTo(List.of(new Car("pobi"), new Car("woni"), new Car("jun")));
    }


}
