package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_이름은_중복될_수_없다() {
        // given
        List<Car> temp = new ArrayList<>();
        temp.add(new Car("pobi"));
        temp.add(new Car("woni"));
        temp.add(new Car("jun"));

        // when
        Cars cars = new Cars(temp);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차_이름이_중복되면_에러가_발생한다() {
        // given
        List<Car> temp = new ArrayList<>();
        temp.add(new Car("pobi"));
        temp.add(new Car("woni"));
        temp.add(new Car("jun"));
        temp.add(new Car("jun"));

        // when & then
        assertThatThrownBy(() -> new Cars(temp)).isInstanceOf(IllegalArgumentException.class);
    }
}
