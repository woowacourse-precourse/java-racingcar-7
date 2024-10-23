package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_이름_저장_테스트(){
        Car car = new Car("phobi,leo,jade,bobo");
        String[] str =
        assertThat(car).isEqualTo(new Car(new String[]{"phobi","leo","jade","bobo"}));
    }
}
