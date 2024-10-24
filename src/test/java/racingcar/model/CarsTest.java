package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 테스트")
public class CarsTest {

    @Test
    void 자통차_리스트를_생성한다(){
        //given
        List<Car> carNames = List.of(
            new Car("pobi"),
            new Car("woni"),
            new Car("javaji")
        );

        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }
}
