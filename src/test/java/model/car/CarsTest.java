package model.car;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 자동차_이름_저장_테스트(){
        Cars cars = new Cars("phob,leo,jade,bobo");
        assertThat(cars).isEqualTo(new Cars(new String[]{"phob","leo","jade","bobo"}));
    }

    @Test
    void 자동차_이름_길이_5글자_에러_테스트() {
        assertThatThrownBy(() -> new Cars("phobiq,leo,jade"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름은 5글자 이하로 입력해주세요.");
    }

    @Test
    void 자동차_리스트_이동() {
        Cars cars = new Cars("phobi,leo,jade");

        cars.repeatMove(3, () -> { return 5; });

        assertThat(cars).isEqualTo(new Cars(List.of(new Car("phobi", 3), new Car("leo", 3), new Car("jade", 3))));
    }

}
