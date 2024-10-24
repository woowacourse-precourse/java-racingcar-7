package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 테스트")
public class CarsTest {

    @Test
    void 자동차_리스트를_생성한다() {
        //given
        List<Car> carNames = List.of(
            new Car("pobi"),
            new Car("woni"),
            new Car("jun")
        );

        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 자동차_목록은_중복될_수_없다() {
        //given
        List<Car> cars = List.of(
            new Car("pobi"),
            new Car("pobi"),
            new Car("woni")
        );

        //when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars));
    }
}
