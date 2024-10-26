package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarCreatorTest {

    @DisplayName("List<String> carNames 가 들어왔을 경우, cars를 성공적으로 생성한다")
    @Test
    void create_cars_test(){
        //given
        List<String> carNames = List.of("pobi", "woni", "kim");
        //when
        List<Car> cars = CarCreator.createCars(carNames);
        //then
        assertThat(cars.size()).isEqualTo(3);
        for (int i=0; i < cars.size(); i++) {
            assertThat(carNames.get(i)).isEqualTo(cars.get(i).getName());
        }
    }


}
