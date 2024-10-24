package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 자동차_이름_저장_테스트(){
        Cars cars = new Cars("phob,leo,jade,bobo");
        assertThat(cars).isEqualTo(new Cars(new String[]{"phob","leo","jade","bobo"}));
    }



}
