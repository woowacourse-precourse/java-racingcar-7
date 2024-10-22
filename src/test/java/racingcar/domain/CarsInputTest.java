package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 중복된_차를_입력했을때_예외_발생(){
        String carsInput="지우,지우,임지우";
        assertThatThrownBy(()->new Cars(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("각 차는 한번만 입력해야 합니다");
    }

    @Test
    void 특정_차가_여섯글자_이상일때_예외_발생(){
        String carsInput="지우,임지우임지우임";
        assertThatThrownBy(()->new Cars(carsInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("차는 다섯글자 이하이어야 합니다");
    }




}