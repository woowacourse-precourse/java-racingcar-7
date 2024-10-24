package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarArgumentResolverTest {

    CarArgumentResolver carArgumentResolver = new CarArgumentResolver();

    @Test
    @DisplayName("자동차 이름 String이 주어졌을 때 ,를 기준으로 정상 parse")
    public void parse_테스트() {
        // given
        String rawCarNames = "a,b,c";

        // when
        List<String> carNames = carArgumentResolver.parse(rawCarNames);

        // then
        Assertions.assertThat(carNames).contains("a");
        Assertions.assertThat(carNames).contains("b");
        Assertions.assertThat(carNames).contains("c");
    }

}