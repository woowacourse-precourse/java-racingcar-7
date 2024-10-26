package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Distance;

public class DistanceTest {

    @Test
    @DisplayName("차의 이동을 테스트한다")
    void create(){
        Distance distance = new Distance();
        assertThat(distance).isEqualTo(new Distance());
    }


}
