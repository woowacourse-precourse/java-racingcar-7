package racingcar.model.car;

import org.junit.jupiter.api.Test;
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
    void 자동차_이동_테스트() {
        Cars cars = new Cars("phobi,leo,luna");

        cars.moves(()-> {return 4;});
        assertThat(cars).isEqualTo(new Cars(List.of(new Car("phobi",1), new Car("leo", 1), new Car("luna",1))));
    }

    @Test
    void 자동차_이동_실패_테스트() {
        Cars cars = new Cars("phobi,leo,luna");
        cars.moves(()-> {return 3;});

        assertThat(cars).isEqualTo(new Cars(List.of(new Car("phobi",0), new Car("leo", 0), new Car("luna",0))));
    }
}
